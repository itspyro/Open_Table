package com.example.opentable.service;

import java.util.List;

import com.example.opentable.transport.dto.FoodOrderDto;
import com.example.opentable.transport.dto.ReturnFoodOrderDto;

public interface FoodOrderService {

	List<Integer> createFoodOrder(FoodOrderDto foodOrderDto) throws Exception;

	ReturnFoodOrderDto getFoodOrderByBooking(int bookingId) throws Exception;

}
