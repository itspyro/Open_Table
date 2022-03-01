package com.example.opentable.transport.dto;

public class BookingFoodOrderDetailsDto {
	
	private int foodOrderId;
	
	private int quantity;
	
	private int price;
	
	private BookingRecipeDetailsDto recipe;

	public BookingFoodOrderDetailsDto() {
		super();
	}

	public int getFoodOrderId() {
		return foodOrderId;
	}

	public void setFoodOrderId(int foodOrderId) {
		this.foodOrderId = foodOrderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public BookingRecipeDetailsDto getRecipe() {
		return recipe;
	}

	public void setRecipe(BookingRecipeDetailsDto recipe) {
		this.recipe = recipe;
	}
	
	
}
