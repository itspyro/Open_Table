package com.example.opentable.transport.dto;

import java.util.List;

import com.example.opentable.repository.entity.Cuisine;

public class RestaurantDto {
	
	private int restaurantId;

	private String restaurantName;

	private String address;

	private String gstIn;

	private String contact;
	
	private boolean nonVeg;

	private String description;
	
	private int userId;
	
	private List<CuisineDto> cuisines;



	public RestaurantDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantDto(int restaurantId, String restaurantName, String address, String gstIn, String contact,
			boolean nonVeg, String description, int userId, List<CuisineDto> cuisines) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.gstIn = gstIn;
		this.contact = contact;
		this.nonVeg = nonVeg;
		this.description = description;
		this.userId = userId;
		this.cuisines = cuisines;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGstIn() {
		return gstIn;
	}

	public void setGstIn(String gstIn) {
		this.gstIn = gstIn;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public boolean isNonVeg() {
		return nonVeg;
	}

	public void setNonVeg(boolean nonVeg) {
		this.nonVeg = nonVeg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUser() {
		return userId;
	}

	public void setUser(int user) {
		this.userId = user;
	}

	public List<CuisineDto> getCuisines() {
		return cuisines;
	}

	public void setCuisines(List<CuisineDto> list) {
		this.cuisines = list;
	}
	
	
	
}
