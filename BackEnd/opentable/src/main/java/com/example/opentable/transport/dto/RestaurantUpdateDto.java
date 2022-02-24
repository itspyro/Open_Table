package com.example.opentable.transport.dto;



public class RestaurantUpdateDto extends CreateRestaurantDto{
	private int restaurantId;

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public RestaurantUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantUpdateDto(int restaurantId) {
		super();
		this.restaurantId = restaurantId;
	}	
	
}
