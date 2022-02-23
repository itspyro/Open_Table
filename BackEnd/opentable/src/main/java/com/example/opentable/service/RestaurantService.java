package com.example.opentable.service;

import java.util.List;

import com.example.opentable.transport.dto.CreateRestaurantDto;
import com.example.opentable.transport.dto.CuisineListDto;
import com.example.opentable.transport.dto.RestaurantDetailDto;
import com.example.opentable.transport.dto.RestaurantDto;

public interface RestaurantService {
	public List<RestaurantDto> getRestaurants() throws Exception;
	
	public List<RestaurantDto> getRestaurantByUser(int userId) throws Exception;
	
	public int createRestaurant(CreateRestaurantDto restaurantDto) throws Exception;
	
	public RestaurantDetailDto getRestaurantById(int restaurantId) throws Exception;
	
	public int deleteRestaurant(int restaurantId) throws Exception;

	public List<RestaurantDto> getRestaurantByCuisine(CuisineListDto cuisineIds) throws Exception;
}
