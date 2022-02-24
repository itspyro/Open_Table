package com.example.opentable.transport.dto;

public class CreateBenchDto  extends BenchDto {

	private Integer restaurantId;
	
	private int noOfBench;

	public CreateBenchDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateBenchDto(Integer restaurantId, int noOfBench) {
		super();
		this.restaurantId = restaurantId;
		this.noOfBench = noOfBench;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getNoOfBench() {
		return noOfBench;
	}

	public void setNoOfBench(int noOfBench) {
		this.noOfBench = noOfBench;
	}

	
}
