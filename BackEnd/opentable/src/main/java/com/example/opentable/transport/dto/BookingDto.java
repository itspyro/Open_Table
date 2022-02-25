package com.example.opentable.transport.dto;


public class BookingDto {

	private int bookingId;
	
	private int userId;
	
	private String paymentId;
	
	private int payment;
	

	public BookingDto() {
		super();
	}


	public BookingDto(int bookingId, int userId, String paymentId, int payment, TableOrderDto tableOrder) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.paymentId = paymentId;
		this.payment = payment;

	}


	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
