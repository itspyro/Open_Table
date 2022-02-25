package com.example.opentable.transport.dto;

import java.util.Date;

public class TableOrderDto {

	private int tableOrderId;
	
	private Date arrivalTime;
	
	private Date departureTime;
	
	private int benchId;
	
	private int bookingId;

	public TableOrderDto() {
		super();
	}

	

	public int getTableOrderId() {
		return tableOrderId;
	}

	public void setTableOrderId(int tableOrderId) {
		this.tableOrderId = tableOrderId;
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

	



	public int getBookingId() {
		return bookingId;
	}



	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}



	public int getBenchId() {
		return benchId;
	}



	public void setBenchId(int benchId) {
		this.benchId = benchId;
	}

	
	
	
}
