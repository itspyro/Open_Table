package com.example.opentable.repository.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.PhotoDao;
import com.example.opentable.repository.dao.Utilities;
import com.example.opentable.repository.entity.Photo;
import com.example.opentable.repository.entity.Restaurant;
import com.example.opentable.transport.dto.CreatePhotoDto;
import com.example.opentable.transport.dto.PhotoDto;

@Repository
public class PhotoDaoImpl extends AbstractParentDao<Photo> implements PhotoDao{
	
	private final String uploadDir = "/Users/harshit.jain/opentable/src/main/resources/static/image";
	
	public PhotoDaoImpl() throws IOException{
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<PhotoDto> getAllPhotos() throws Exception {
		try {
			List<Photo> photos = new ArrayList<>();
			Query query = getEntityManager().createQuery("select p from Photo p");
			photos = query.getResultList();
			return convertPhotosIntoDto(photos);
		}
		catch(Exception e) {
			throw e;
		}
	}

	private List<PhotoDto> convertPhotosIntoDto(List<Photo> photos) {
		try {
			List<PhotoDto> photoDtos = new ArrayList<>();
			if(photos != null && photos.isEmpty()==false) {
				for(Photo photo:photos) {
					PhotoDto photoDto = new PhotoDto();
					photoDto.setPhotoId(photo.getPhotoId());
					photoDto.setPhotoUrl(photo.getPhotoUrl());
					photoDtos.add(photoDto);
				}
			}
			return photoDtos;
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<PhotoDto> getPhotoById(int photoId) throws Exception {
		try {
			Query query = getEntityManager().createQuery("select p from Photo p");
			List<Photo> photos = query.getResultList();
			return convertPhotosIntoDto(photos);
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<PhotoDto> getRestaurantPhoto(int restaurantId) throws Exception {
		try {
			List<Photo> photos = new ArrayList<>();
			Query query = getEntityManager().createQuery("select r.photos from Restaurant r"
					+ " where r.restaurantId = :id").setParameter("id", restaurantId);
			photos = query.getResultList();
			return convertPhotosIntoDto(photos);
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int createPhoto(CreatePhotoDto photoDto) throws Exception {
		try {
			Photo photo = new Photo();
			Restaurant restaurant = getEntityManager().getReference(Restaurant.class, photoDto.getRestaurantId());
			photo.setRestaurant(restaurant);
			photo.setPhotoUrl(photoDto.getPhotoUrl());
			save(photo);
			return photo.getPhotoId();
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	public int deletePhoto(int photoId) throws Exception {
		int noOfEntityDeleted = 0;
		try {
			Query query = getEntityManager().createQuery("delete from Photo p where p.photoId = :id").setParameter("id", photoId);
			noOfEntityDeleted = query.executeUpdate();
			return noOfEntityDeleted;
		}
		catch(Exception e) {
			throw e;
		}
	}

}
