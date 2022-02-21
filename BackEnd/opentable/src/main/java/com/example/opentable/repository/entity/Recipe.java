package com.example.opentable.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="recipes")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private int recipeId;
	
	@Column
	private String recipeName;
	
	@Column 
	private int price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recipe(int recipeId, String recipeName, int price, Restaurant restaurant) {
		super();
		this.recipeName = recipeName;
		this.price = price;
		this.restaurant = restaurant;
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

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeName=" + recipeName + ", price=" + price + "]";
	}

}
