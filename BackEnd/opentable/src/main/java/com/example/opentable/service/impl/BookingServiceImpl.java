package com.example.opentable.service.impl;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.BookingDao;
import com.example.opentable.repository.dao.FoodOrderDao;
import com.example.opentable.repository.entity.Booking;
import com.example.opentable.repository.entity.User;
import com.example.opentable.service.BookingService;
import com.example.opentable.transport.ResponseMessage;
import com.example.opentable.transport.dto.BookingDto;
import com.example.opentable.transport.dto.CreateBookingDto;
import com.example.opentable.transport.dto.FoodOrderDto;
import com.example.opentable.transport.dto.RestaurantBookingsDto;
import com.example.opentable.transport.dto.UserBookingsDto;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;


@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingDao bookingDao;
	
	@Autowired
	FoodOrderDao foodOrderDao;
	

	@Override
	public List<UserBookingsDto> getAllBookingsByUser(int userId) throws Exception {
		return bookingDao.getAllBookingsByUser(userId);
	}

	@Override
	public String createBooking(CreateBookingDto createBookingDto) throws Exception {
		ResponseMessage response = new ResponseMessage();
		RazorpayClient client = new RazorpayClient("rzp_test_LecrG02AfeAeEm","q6zde4WjNWhD84FXeKZqSQAf");
		
		JSONObject orderJson = new JSONObject();
		orderJson.put("amount", createBookingDto.getPayment()*100);
		orderJson.put("currency", "INR");
		
		Order order = client.Orders.create(orderJson);
		System.out.print(order);
		int payment = order.get("amount");
		payment = payment /100;
		Booking booking = new Booking();
		createBookingDto.setOrderId(order.get("id"));
		createBookingDto.setPayment(payment);
		createBookingDto.setPaymentId(null);
		createBookingDto.setStatus("created");
		int bookingId = bookingDao.createBooking(createBookingDto);
		FoodOrderDto foodOrder = createBookingDto.getFoodOrder();
		foodOrder.setBookingId(bookingId);
		foodOrderDao.createFoodOrder(foodOrder);
		createBookingDto.setStatus("Created");
		
		return order.toString();
	}

	@Override
	public List<RestaurantBookingsDto> getAllBookingsByRestaurant(int restaurantId, int userId) throws Exception {
		return bookingDao.getAllBookingsByRestaurant(restaurantId, userId);
	}
	
	
	
}
