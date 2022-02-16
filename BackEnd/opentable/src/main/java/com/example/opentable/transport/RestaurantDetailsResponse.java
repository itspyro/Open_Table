package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.RestaurantDto;

public class RestaurantDetailsResponse extends ResponseMessage implements Serializable {

	private static final long serialVersionUID = 6706133980935628258L;

	private List<RestaurantDto> restaurants;

	public RestaurantDetailsResponse() {

	}

	public List<RestaurantDto> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<RestaurantDto> restaurants) {
		this.restaurants = restaurants;
	}
	
	
}
