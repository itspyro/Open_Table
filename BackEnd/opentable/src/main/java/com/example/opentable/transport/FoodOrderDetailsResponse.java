package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.opentable.transport.dto.FoodOrderDto;
import com.example.opentable.transport.dto.ReturnFoodOrderDto;

public class FoodOrderDetailsResponse extends ResponseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6884924034701030403L;
	
	ReturnFoodOrderDto foodOrders;

	public FoodOrderDetailsResponse() {
		super();
	}

	public ReturnFoodOrderDto getFoodOrders() {
		return foodOrders;
	}

	public void setFoodOrders(ReturnFoodOrderDto foodOrders) {
		this.foodOrders = foodOrders;
	}
	
	
}
