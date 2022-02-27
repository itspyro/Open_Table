package com.example.opentable.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.opentable.transport.dto.CreatePhotoDto;
import com.example.opentable.transport.dto.PhotoDto;

public interface PhotoService {
    public List<PhotoDto> getAllPhotos() throws Exception;
	
	public List<PhotoDto> getPhotoById(int photoId) throws Exception;
	
	public List<PhotoDto> getRestaurantPhoto(int restaurantId) throws Exception;
	
	public int createPhoto(CreatePhotoDto photoDto) throws Exception;
	
	public int deletePhoto(int photoId) throws Exception;
	
	public String uploadFile(MultipartFile file) throws Exception;
	
}
