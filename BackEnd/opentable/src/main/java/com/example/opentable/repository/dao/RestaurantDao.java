package com.example.opentable.repository.dao;

import java.util.List;

import com.example.opentable.transport.dto.CreateRestaurantDto;
import com.example.opentable.transport.dto.FilterDto;
import com.example.opentable.transport.dto.RestaurantDetailDto;
import com.example.opentable.transport.dto.RestaurantDto;
import com.example.opentable.transport.dto.RestaurantUpdateDto;

public interface RestaurantDao {
	
	public List<RestaurantDto> getRestaurants() throws Exception;
	
	public List<RestaurantDto> getRestaurantByUser(int userId) throws Exception;
	
	public int createRestaurant(CreateRestaurantDto restaurantDto) throws Exception;
	
	public RestaurantDetailDto getRestaurantById(int restaurantId) throws Exception;
	
	public int deleteRestaurant(int restaurantId) throws Exception;
	
	public List<RestaurantDto> getRestaurantsByFilter(FilterDto filter) throws Exception;
	
	public int updateRestaurant(RestaurantUpdateDto restaurantDto) throws Exception;
	
}
