package com.example.opentable.transport.dto;

public class FoodOrderDto {
	
	private int foodOrderId;
	
	private int Quantity;
	
	private int price;
	
	private BookingDto booking;
	
	private RecipeDto recipe;

	public FoodOrderDto() {
		super();
	}

	public FoodOrderDto(int foodOrderId, int quantity, int price, BookingDto booking, RecipeDto recipe) {
		super();
		this.foodOrderId = foodOrderId;
		Quantity = quantity;
		this.price = price;
		this.booking = booking;
		this.recipe = recipe;
	}

	public int getFoodOrderId() {
		return foodOrderId;
	}

	public void setFoodOrderId(int foodOrderId) {
		this.foodOrderId = foodOrderId;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public BookingDto getBooking() {
		return booking;
	}

	public void setBooking(BookingDto booking) {
		this.booking = booking;
	}

	public RecipeDto getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeDto recipe) {
		this.recipe = recipe;
	}
	
	

}
