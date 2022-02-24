package com.example.opentable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.RestaurantDao;
import com.example.opentable.service.RestaurantService;
import com.example.opentable.transport.dto.CreateRestaurantDto;
import com.example.opentable.transport.dto.CuisineListDto;
import com.example.opentable.transport.dto.RestaurantDetailDto;
import com.example.opentable.transport.dto.RestaurantDto;
import com.example.opentable.transport.dto.RestaurantUpdateDto;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantDao restaurantDao;
	
	@Override
	public List<RestaurantDto> getRestaurants() throws Exception {
		return restaurantDao.getRestaurants();
	}

	@Override
	public int createRestaurant(CreateRestaurantDto restaurantDto) throws Exception {
		if(restaurantDto.getUserId()==0) {
			return -1;
		}
		return restaurantDao.createRestaurant(restaurantDto);
	}

	@Override
	public RestaurantDetailDto getRestaurantById(int restaurantId) throws Exception {
		return restaurantDao.getRestaurantById(restaurantId);
	}

	@Override
	public int deleteRestaurant(int restaurantId) throws Exception {
		return restaurantDao.deleteRestaurant(restaurantId);
	}

	@Override
	public List<RestaurantDto> getRestaurantByUser(int userId) throws Exception {
		return restaurantDao.getRestaurantByUser(userId);
	}

	@Override
	public List<RestaurantDto> getRestaurantByCuisine(CuisineListDto cuisineIds) throws Exception {
		return restaurantDao.getRestaurantsByCuisine(cuisineIds);
	}

	@Override
	public int updateRestaurant(RestaurantUpdateDto restaurantDto) throws Exception {
		return restaurantDao.updateRestaurant(restaurantDto);
	}

	
	

}
