package com.example.opentable.transport.dto;

public class CreateRecipeDto extends RecipeDto {

	private int restaurantId;

	public CreateRecipeDto() {
		super();
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
}
