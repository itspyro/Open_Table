package com.example.opentable.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public int deletePhoto(int photoId) throws Exception {
		return photoDao.deletePhoto(photoId);
	}
	
	@Override
	public String uploadFile(MultipartFile file) throws Exception{	
		 Path uploadPath = Paths.get("/Users/harshit.jain/Table_booking/src/assets/images");
		 String filename = StringUtils.cleanPath(file.getOriginalFilename());
		 filename = filename.toLowerCase().replaceAll(" ", "-");
		 try (InputStream inputStream = file.getInputStream()) {
		 	Path filePath = uploadPath.resolve(filename);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			String photoUrl = "assets/images/"+filename;
			return photoUrl;
		 }
	     catch (IOException ioe) {       
	    	 throw new IOException("Could not save image file: " + file.getOriginalFilename(), ioe);
	     }
	     catch(Exception e) {
	         throw e;
	     }
	}
	
	@Override 
	public int createPhoto(CreatePhotoDto photoDto) throws Exception {
		return photoDao.createPhoto(photoDto);
	}

}
