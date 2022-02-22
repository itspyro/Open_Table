package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.FoodOrderDto;

public class FoodOrderDetailsResponse extends ResponseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6884924034701030403L;
	
	List<FoodOrderDto> foodOrders;

	public FoodOrderDetailsResponse() {
		super();
	}

	public List<FoodOrderDto> getFoodOrders() {
		return foodOrders;
	}

	public void setFoodOrders(List<FoodOrderDto> foodOrders) {
		this.foodOrders = foodOrders;
	}
	
	
}
