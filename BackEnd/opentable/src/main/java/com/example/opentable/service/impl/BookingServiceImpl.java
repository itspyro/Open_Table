package com.example.opentable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.BookingDao;
import com.example.opentable.service.BookingService;
import com.example.opentable.transport.dto.BookingDto;
import com.example.opentable.transport.dto.CreateBookingDto;
import com.example.opentable.transport.dto.RestaurantBookingsDto;
import com.example.opentable.transport.dto.UserBookingsDto;


@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingDao bookingDao;
	

	@Override
	public List<UserBookingsDto> getAllBookingsByUser(int userId) throws Exception {
		return bookingDao.getAllBookingsByUser(userId);
	}

	@Override
	public int createBooking(CreateBookingDto createBookingDto) throws Exception {
		return bookingDao.createBooking(createBookingDto);
	}

	@Override
	public List<RestaurantBookingsDto> getAllBookingsByRestaurant(int restaurantId, int userId) throws Exception {
		return bookingDao.getAllBookingsByRestaurant(restaurantId, userId);
	}
	
	
	
}
