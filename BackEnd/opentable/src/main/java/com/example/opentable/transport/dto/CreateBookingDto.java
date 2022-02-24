package com.example.opentable.transport.dto;

import java.util.Date;

public class CreateBookingDto {
	
	private int noOfPerson;
	
	private Date arrivalTime;
	
	private Date departureTime;
	
	private int payment;
	
	private String paymentId;
	
	private int restaurantId;
	
	private int userId;
	
	private int benchId;
	

	public CreateBookingDto() {
		super();
	}

	public int getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBenchId() {
		return benchId;
	}

	public void setBenchId(int benchId) {
		this.benchId = benchId;
	}
	
	

}
