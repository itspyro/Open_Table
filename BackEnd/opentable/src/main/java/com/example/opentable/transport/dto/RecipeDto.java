package com.example.opentable.transport.dto;


public class RecipeDto {

	private int recipeId;
	
	private String recipeName;

	private int price;

	public RecipeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecipeDto(int recipeId, String recipeName, int price) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.price = price;
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
