package com.example.opentable.transport.dto;


public class CreateReviewDto extends ReviewDto{
	private int userId;
	
	private int restaurantId;

	public CreateReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CreateReviewDto(int userId, int restaurantId) {
		super();
		this.userId = userId;
		this.restaurantId = restaurantId;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
	
}
