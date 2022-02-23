package com.example.opentable.transport;

import java.io.Serializable;


import com.example.opentable.transport.dto.RestaurantDetailDto;

public class RestaurantDetailsResponse extends ResponseMessage implements Serializable {

	private static final long serialVersionUID = 6706133980935628258L;

	private RestaurantDetailDto restaurant;

	public RestaurantDetailsResponse() {

	}

	public RestaurantDetailDto getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDetailDto restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
