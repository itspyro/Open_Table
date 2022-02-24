package com.example.opentable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.BookingDao;
import com.example.opentable.service.BookingService;
import com.example.opentable.transport.dto.BookingDto;
import com.example.opentable.transport.dto.CreateBookingDto;


@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingDao bookingDao;
	

	@Override
	public List<BookingDto> getAllBookingsByUser(int userId) throws Exception {
		
		return bookingDao.getAllBookingsByUser(userId);
	}

	@Override
	public int createBooking(CreateBookingDto createBookingDto) throws Exception {
		return bookingDao.createBooking(createBookingDto);
	}
	
	
	
}
