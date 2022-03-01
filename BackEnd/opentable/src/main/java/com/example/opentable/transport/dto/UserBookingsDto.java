package com.example.opentable.transport.dto;

import java.util.List;

public class UserBookingsDto {

	private int bookingId;
	
	private BookingRestaurantDetailsDto restaurant;
	
	private List<BookingFoodOrderDetailsDto> foodOrder;
	
	private BookingTableOrderDetailsDto tableOrder;

	public UserBookingsDto() {
		super();
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public BookingRestaurantDetailsDto getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(BookingRestaurantDetailsDto restaurant) {
		this.restaurant = restaurant;
	}

	public List<BookingFoodOrderDetailsDto> getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(List<BookingFoodOrderDetailsDto> foodOrder) {
		this.foodOrder = foodOrder;
	}

	public BookingTableOrderDetailsDto getTableOrder() {
		return tableOrder;
	}

	public void setTableOrder(BookingTableOrderDetailsDto tableOrder) {
		this.tableOrder = tableOrder;
	}
	
	
}
