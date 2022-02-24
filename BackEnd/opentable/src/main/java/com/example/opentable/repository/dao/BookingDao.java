package com.example.opentable.repository.dao;

import java.util.List;

import com.example.opentable.transport.dto.BookingDto;
import com.example.opentable.transport.dto.CreateBookingDto;

public interface BookingDao {

	public List<BookingDto> getAllBookingsByUser(int userId);

	public int createBooking(CreateBookingDto createBookingDto);
}
