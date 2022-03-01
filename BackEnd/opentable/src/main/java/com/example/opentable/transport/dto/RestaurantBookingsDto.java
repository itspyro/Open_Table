package com.example.opentable.transport.dto;

import java.util.List;

public class RestaurantBookingsDto {

	private int bookingId;
	
	private BookingUserDetailsDto user;
	
	private List<BookingFoodOrderDetailsDto> foodOrder;
	
	private BookingTableOrderDetailsDto tableOrder;

	public RestaurantBookingsDto() {
		super();
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public BookingUserDetailsDto getUser() {
		return user;
	}

	public void setUser(BookingUserDetailsDto user) {
		this.user = user;
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
