package com.example.opentable.repository.dao;

import java.util.List;

import com.example.opentable.transport.dto.CreatePhotoDto;
import com.example.opentable.transport.dto.PhotoDto;

public interface PhotoDao {
	
	public List<PhotoDto> getAllPhotos() throws Exception;
	
	public List<PhotoDto> getPhotoById(int photoId) throws Exception;
	
	public List<PhotoDto> getRestaurantPhoto(int restaurantId) throws Exception;
	
	public int createPhoto(CreatePhotoDto photoDto) throws Exception;
}
