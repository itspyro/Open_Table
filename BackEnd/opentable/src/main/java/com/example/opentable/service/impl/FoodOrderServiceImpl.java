package com.example.opentable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.opentable.repository.dao.FoodOrderDao;
import com.example.opentable.service.FoodOrderService;
import com.example.opentable.transport.dto.FoodOrderDto;
import com.example.opentable.transport.dto.ReturnFoodOrderDto;

@Repository
public class FoodOrderServiceImpl implements FoodOrderService{

	@Autowired
	FoodOrderDao foodOrderDao;

	@Override
	public List<Integer> createFoodOrder(FoodOrderDto foodOrderDto) throws Exception{
		return foodOrderDao.createFoodOrder(foodOrderDto);
	}

	@Override
	public ReturnFoodOrderDto getFoodOrderByBooking(int bookingId) throws Exception{
		return foodOrderDao.getFoodOrderByBooking(bookingId);
	}

}