package com.example.opentable.transport.dto;

import java.util.List;


public class CuisineDto {
	
	private int cuisineId;

	private String cuisineName;

    private List<RestaurantDto> restaurants;
    

	public CuisineDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuisineDto(int cuisineId, String cuisineName, List<RestaurantDto> restaurants) {
		super();
		this.cuisineId = cuisineId;
		this.cuisineName = cuisineName;
		this.restaurants = restaurants;
	}

	public int getCuisineId() {
		return cuisineId;
	}

	public void setCuisineId(int cuisineId) {
		this.cuisineId = cuisineId;
	}

	public String getCuisineName() {
		return cuisineName;
	}

	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

	public List<RestaurantDto> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<RestaurantDto> restaurants) {
		this.restaurants = restaurants;
	}
    
    
}
