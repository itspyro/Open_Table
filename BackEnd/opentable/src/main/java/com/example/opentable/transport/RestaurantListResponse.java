package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.RestaurantDto;

public class RestaurantListResponse extends ResponseMessage implements Serializable{
	
	private static final long serialVersionUID = -6262884747080428174L;
	private List<RestaurantDto> restaurants;

	public RestaurantListResponse() {

	}

	public List<RestaurantDto> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<RestaurantDto> restaurants) {
		this.restaurants = restaurants;
	}
	
}
