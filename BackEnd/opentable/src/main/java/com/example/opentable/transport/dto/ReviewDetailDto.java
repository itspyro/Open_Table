package com.example.opentable.transport.dto;



public class ReviewDetailDto extends ReviewDto{
	private UserDto user;

	private RestaurantDto restaurant;

	public ReviewDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewDetailDto(UserDto user, RestaurantDto restaurant) {
		super();
		this.user = user;
		this.restaurant = restaurant;
	}


	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public RestaurantDto getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDto restaurant) {
		this.restaurant = restaurant;
	}	
	
}
