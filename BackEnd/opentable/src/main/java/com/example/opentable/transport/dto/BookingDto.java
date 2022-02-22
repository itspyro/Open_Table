package com.example.opentable.transport.dto;

public class BookingDto {

	private int bookingId;
	
	private UserDto user;
	
	private String paymentId;
	
	private int payment;

	public BookingDto() {
		super();
	}

	public BookingDto(int bookingId, UserDto user, String paymentId, int payment) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.paymentId = paymentId;
		this.payment = payment;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	
}
