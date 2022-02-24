package com.example.opentable.service;

import java.util.List;

import com.example.opentable.transport.dto.CuisineDto;

public interface CuisineService {
	public List<CuisineDto> getAllCuisine() throws Exception;
	
	public List<CuisineDto> getCuisineByRestaurant(int restaurant_Id) throws Exception;
	
	public int createCuisine(CuisineDto cuisineDto) throws Exception;
	
	public int deleteCuisine(int cuisineId) throws Exception;
}
