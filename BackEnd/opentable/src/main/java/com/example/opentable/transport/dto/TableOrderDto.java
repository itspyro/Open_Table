package com.example.opentable.transport.dto;

import java.util.Date;

public class TableOrderDto {

	private int tableOrderId;
	
	private Date arrivalTime;
	
	private Date departureTime;
	
	private BenchDto bench;
	
	private BookingDto booking;

	public TableOrderDto() {
		super();
	}

	public TableOrderDto(int tableOrderId, Date arrivalTime, Date departureTime, BenchDto bench, BookingDto booking) {
		super();
		this.tableOrderId = tableOrderId;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.bench = bench;
		this.booking = booking;
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

	public BenchDto getBench() {
		return bench;
	}

	public void setBench(BenchDto bench) {
		this.bench = bench;
	}

	public BookingDto getBooking() {
		return booking;
	}

	public void setBooking(BookingDto booking) {
		this.booking = booking;
	}
	
	
}
