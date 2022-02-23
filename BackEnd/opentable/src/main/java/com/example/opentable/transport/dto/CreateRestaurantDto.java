package com.example.opentable.transport.dto;

import java.util.List;

public class CreateRestaurantDto extends RestaurantDto {
	
	private int userId;
	
	private List<CuisineDto> cuisineIds;

	public CreateRestaurantDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	public List<CuisineDto> getCuisineIds() {
		return cuisineIds;
	}



	public void setCuisineIds(List<CuisineDto> cuisineIds) {
		this.cuisineIds = cuisineIds;
	}



	public CreateRestaurantDto(int userId, List<CuisineDto> cuisineIds) {
		super();
		this.userId = userId;
		this.cuisineIds = cuisineIds;
	}

	
	
	
}
