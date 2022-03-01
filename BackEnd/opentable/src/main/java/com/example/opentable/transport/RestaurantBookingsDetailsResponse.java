package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.RestaurantBookingsDto;

public class RestaurantBookingsDetailsResponse extends ResponseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3537793443312630920L;

	private int restaurantId;
	
	private int userId;
	
	private List<RestaurantBookingsDto> restaurantBookings;

	public RestaurantBookingsDetailsResponse() {
		super();
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<RestaurantBookingsDto> getRestaurantBookings() {
		return restaurantBookings;
	}

	public void setRestaurantBookings(List<RestaurantBookingsDto> restaurantBookings) {
		this.restaurantBookings = restaurantBookings;
	}
	
	
	
}
