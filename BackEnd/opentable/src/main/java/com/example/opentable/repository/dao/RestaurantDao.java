package com.example.opentable.repository.dao;

import java.util.List;

import com.example.opentable.transport.dto.RestaurantDto;

public interface RestaurantDao {
	
	public List<RestaurantDto> getRestaurants() throws Exception;
	
	public int createRestaurant(RestaurantDto restaurantDto) throws Exception;
	
	public List<RestaurantDto> getRestaurantById(int restaurantId) throws Exception;
	
	public int deleteRestaurant(int restaurantId) throws Exception;
}
