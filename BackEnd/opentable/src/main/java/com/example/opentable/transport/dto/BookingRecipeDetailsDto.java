package com.example.opentable.transport.dto;

public class BookingRecipeDetailsDto {

	private int recipeId;
	
	private String recipeName;

	private int price;

	public BookingRecipeDetailsDto() {
		super();
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
