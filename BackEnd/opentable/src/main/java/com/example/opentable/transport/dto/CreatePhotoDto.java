package com.example.opentable.transport.dto;


public class CreatePhotoDto extends PhotoDto {
	private int restaurantId;
	
	

	public CreatePhotoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreatePhotoDto(int restaurantId) {
		super();
		this.restaurantId = restaurantId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


}
	
	
