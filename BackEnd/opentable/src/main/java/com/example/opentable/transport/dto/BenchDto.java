package com.example.opentable.transport.dto;


public class BenchDto {
	
	private int benchId;
	
	private String benchType;

	private int capacity;
	
	private RestaurantDto restaurant;

	public BenchDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BenchDto(int benchId, String benchType, int capacity, RestaurantDto restaurant) {
		super();
		this.benchId = benchId;
		this.benchType = benchType;
		this.capacity = capacity;
		this.restaurant = restaurant;
	}

	public int getBenchId() {
		return benchId;
	}

	public void setBenchId(int benchId) {
		this.benchId = benchId;
	}

	public String getBenchType() {
		return benchType;
	}

	public void setBenchType(String benchType) {
		this.benchType = benchType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public RestaurantDto getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDto restaurant) {
		this.restaurant = restaurant;
	}
	
	
}