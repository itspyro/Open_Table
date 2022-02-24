package com.example.opentable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.CuisineDao;
import com.example.opentable.service.CuisineService;
import com.example.opentable.transport.dto.CuisineDto;

@Service
public class CuisineServiceImpl implements CuisineService {

	@Autowired 
	CuisineDao cuisineDao;
	
	@Override
	public List<CuisineDto> getAllCuisine() throws Exception {
		return cuisineDao.getAllCuisines();
	}

	@Override
	public List<CuisineDto> getCuisineByRestaurant(int restaurant_Id) throws Exception {
		return cuisineDao.getRestaurantCuisines(restaurant_Id);
	}

	@Override
	public int createCuisine(CuisineDto cuisineDto) throws Exception {
		return cuisineDao.createCuisine(cuisineDto);
	}

	@Override
	public int deleteCuisine(int cuisineId) throws Exception {
		return cuisineDao.deleteCuisine(cuisineId);
	}

}
