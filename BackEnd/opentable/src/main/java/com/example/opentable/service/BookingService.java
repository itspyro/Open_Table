package com.example.opentable.service;

import java.util.List;

import com.example.opentable.transport.dto.BookingDto;
import com.example.opentable.transport.dto.CreateBookingDto;
import com.example.opentable.transport.dto.RestaurantBookingsDto;
import com.example.opentable.transport.dto.UserBookingsDto;

public interface BookingService {

	public List<UserBookingsDto> getAllBookingsByUser(int userId) throws Exception;
	
	int createBooking(CreateBookingDto createBookingDto) throws Exception;

	public List<RestaurantBookingsDto> getAllBookingsByRestaurant(int restaurantId, int userId) throws Exception;
}
