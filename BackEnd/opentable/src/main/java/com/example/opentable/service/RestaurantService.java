package com.example.opentable.service;

import java.util.List;

import com.example.opentable.transport.dto.CuisineListDto;
import com.example.opentable.transport.dto.RestaurantDto;

public interface RestaurantService {
	public List<RestaurantDto> getRestaurants() throws Exception;
	
	public List<RestaurantDto> getRestaurantByUser(int userId) throws Exception;
	
	public int createRestaurant(RestaurantDto restaurantDto) throws Exception;
	
	public List<RestaurantDto> getRestaurantById(int restaurantId) throws Exception;
	
	public int deleteRestaurant(int restaurantId) throws Exception;

	public List<RestaurantDto> getRestaurantByCuisine(CuisineListDto cuisineIds) throws Exception;
}
