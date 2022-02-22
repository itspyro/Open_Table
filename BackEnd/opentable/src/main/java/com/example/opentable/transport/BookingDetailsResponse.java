package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.BookingDto;

public class BookingDetailsResponse extends ResponseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5034816146805589928L;

	List<BookingDto> bookings;

	public BookingDetailsResponse() {
	
	}

	public List<BookingDto> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingDto> bookings) {
		this.bookings = bookings;
	}
	
	
	
}
