package com.example.opentable.transport.dto;


public class BenchDto {
	
	private int benchId;
	
	private String benchType;

	private int capacity;
	
	private int price;

	public BenchDto() {
		super();
	}

	

	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public BenchDto(int benchId, String benchType, int capacity, int price) {
		super();
		this.benchId = benchId;
		this.benchType = benchType;
		this.capacity = capacity;
		this.price = price;
	}



	public int getBenchId() {
		return benchId;
	}

	public void setBenchId(int benchId) {
		this.benchId = benchId;
	}

	public String getBenchType() {
		return benchType;
	}

	public void setBenchType(String benchType) {
		this.benchType = benchType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
