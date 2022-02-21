package com.example.opentable.transport.dto;

public class CreateBenchDto  extends BenchDto {

	private Integer restaurantId;

	public CreateBenchDto() {
		super();
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	
}
