package com.example.opentable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.jwt.ValidateToken;
import com.example.opentable.repository.dao.Utilities;
import com.example.opentable.service.BookingService;
import com.example.opentable.transport.BookingDetailsResponse;
import com.example.opentable.transport.ResponseMessage;
import com.example.opentable.transport.dto.CreateBookingDto;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/user/{id}")
	public ResponseEntity<BookingDetailsResponse> getAllBookingsByUser(@RequestHeader("Token") String token, @PathVariable(value = "id") int userId)
	{
		BookingDetailsResponse response = new BookingDetailsResponse();
		try
		{
			ValidateToken tokenObj = new ValidateToken();
			int id = tokenObj.parseJWT(token);
			
			if(id == -1) {
				response.setHttpStatusCode(HttpStatus.UNAUTHORIZED.value());
				response.setResponseMessage("Token expired");
			}
			else {
				Utilities.check(userId, id);
			
				response.setBookings(bookingService.getAllBookingsByUser(userId));
				response.setHttpStatusCode(HttpStatus.OK.value());
				response.setResponseMessage("Successful");
			}
		}
		
		catch(Exception e)		{
			response.setBookings(null);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
		
		return new ResponseEntity<BookingDetailsResponse>(response, HttpStatus.OK);
		
	}
	
	@GetMapping("user/{id}/restaurant/{id2}")
	public ResponseEntity<BookingDetailsResponse> getAllBookingsByRestaurant(@RequestHeader("Token") String token, 
			@PathVariable(value = "id") int userId, @PathVariable(value = "id2") int restaurantId)
	{
		BookingDetailsResponse response = new BookingDetailsResponse();
		try
		{
			ValidateToken tokenObj = new ValidateToken();
			int id = tokenObj.parseJWT(token);
			
			if(id == -1) {
				response.setHttpStatusCode(HttpStatus.UNAUTHORIZED.value());
				response.setResponseMessage("Token expired");
			}
			else {
				Utilities.check(userId, id);
			
				response.setBookings(bookingService.getAllBookingsByRestaurant(restaurantId, userId));
				response.setHttpStatusCode(HttpStatus.OK.value());
				response.setResponseMessage("Successful");
			}
		}
		
		catch(Exception e)		{
			response.setBookings(null);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
		
		return new ResponseEntity<BookingDetailsResponse>(response, HttpStatus.OK);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> createBooking(@RequestBody CreateBookingDto createBookingDto)
	{
		int bookingId;
		ResponseMessage response = new ResponseMessage();
		try
		{
			bookingId = bookingService.createBooking(createBookingDto);
			response.setResponseMessage(String.format("Booking with id %d is created", bookingId));
			response.setHttpStatusCode(HttpStatus.OK.value());
		}
		
		catch(Exception e)
		{
			response.setResponseMessage(e.getMessage());
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<ResponseMessage> (response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<ResponseMessage> (response,HttpStatus.OK);
	}
	
	
	

}
