package com.example.opentable.transport.dto;

public class BookingTableOrderDetailsDto {
	
	private int tableOrderId;
	
	private int persons;
	
	private int tablePrice;
	
	private String arrivalTime;
	
	private String date;

	public BookingTableOrderDetailsDto() {
		super();
	}

	public int getTableOrderId() {
		return tableOrderId;
	}

	public void setTableOrderId(int tableOrderId) {
		this.tableOrderId = tableOrderId;
	}

	public int getPersons() {
		return persons;
	}

	public void setPersons(int persons) {
		this.persons = persons;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTablePrice() {
		return tablePrice;
	}

	public void setTablePrice(int tablePrice) {
		this.tablePrice = tablePrice;
	}
	
	
}
