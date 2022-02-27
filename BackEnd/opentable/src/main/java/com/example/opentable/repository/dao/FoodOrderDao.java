package com.example.opentable.repository.dao;

import java.util.List;

import com.example.opentable.transport.dto.FoodOrderDto;
import com.example.opentable.transport.dto.ReturnFoodOrderDto;

public interface FoodOrderDao {

	List<Integer> createFoodOrder(FoodOrderDto foodOrderDto) throws Exception;

	ReturnFoodOrderDto getFoodOrderByBooking(int bookingId) throws Exception;
	
}
