package com.example.opentable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.PhotoDao;
import com.example.opentable.service.PhotoService;
import com.example.opentable.transport.dto.CreatePhotoDto;
import com.example.opentable.transport.dto.PhotoDto;

@Service
public class PhotoServiceImpl implements PhotoService {
	
	@Autowired
	PhotoDao photoDao;
	
	
	@Override
	public List<PhotoDto> getAllPhotos() throws Exception {
		return photoDao.getAllPhotos();
	}

	@Override
	public List<PhotoDto> getPhotoById(int photoId) throws Exception {
		
		return photoDao.getPhotoById(photoId);
	}

	@Override
	public List<PhotoDto> getRestaurantPhoto(int restaurantId) throws Exception {
		return photoDao.getRestaurantPhoto(restaurantId);
	}

	@Override
	public int createPhoto(CreatePhotoDto photoDto) throws Exception {
		return photoDao.createPhoto(photoDto);
	}

	@Override
	public int deletePhoto(int photoId) throws Exception {
		return photoDao.deletePhoto(photoId);
	}

}
