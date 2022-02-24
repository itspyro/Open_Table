package com.example.opentable.service;

import java.util.List;

import com.example.opentable.transport.dto.BookingDto;
import com.example.opentable.transport.dto.CreateBookingDto;

public interface BookingService {

	public List<BookingDto> getAllBookingsByUser(int userId) throws Exception;
	
	int createBooking(CreateBookingDto createBookingDto) throws Exception;
}
