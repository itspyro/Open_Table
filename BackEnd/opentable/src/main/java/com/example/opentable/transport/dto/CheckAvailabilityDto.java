package com.example.opentable.transport.dto;




public class CheckAvailabilityDto {

	private int noOfPersons;
	
	private Long arrivalTime;
	
	private Long departureTime;
	
	private String benchType;
	
	private int restaurantId;
	
	
	public CheckAvailabilityDto() {
		super();
	}

	public int getNoOfPersons() {
		return noOfPersons;
	}

	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}

	public Long getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Long getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Long departureTime) {
		this.departureTime = departureTime;
	}

	public String getBenchType() {
		return benchType;
	}

	public void setBenchType(String benchType) {
		this.benchType = benchType;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
	
}
