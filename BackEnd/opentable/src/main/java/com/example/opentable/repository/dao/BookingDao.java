package com.example.opentable.repository.dao;

import java.util.List;

import com.example.opentable.transport.dto.BookingDto;
import com.example.opentable.transport.dto.CreateBookingDto;

public interface BookingDao {

	public List<BookingDto> getAllBookingsByUser(int userId) throws Exception;

	public int createBooking(CreateBookingDto createBookingDto) throws Exception;

	public List<BookingDto> getAllBookingsByRestaurant(int restaurantId, int userId) throws Exception;
}
