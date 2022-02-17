package com.example.opentable.repository.dao;

import java.util.List;

import com.example.opentable.transport.dto.CuisineDto;

public interface CuisineDao{
	public List<CuisineDto> getAllCuisines();
	
	public List<CuisineDto> getRestaurantCuisines(int restaurantId);
	
	public int createCuisine(CuisineDto cuisineDto);
	
}
