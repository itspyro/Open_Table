package com.example.opentable.repository.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="recipes")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private int recipe_Id;
	
	@Column
	private String recipe_Name;
	
	@Column 
	private int price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "restaurant_Id")
	private Restaurant restaurant;

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recipe(int recipe_Id, String recipe_Name, int price, Restaurant restaurant) {
		super();
		this.recipe_Id = recipe_Id;
		this.recipe_Name = recipe_Name;
		this.price = price;
		this.restaurant = restaurant;
	}

	public int getRecipe_Id() {
		return recipe_Id;
	}

	public void setRecipe_Id(int recipe_Id) {
		this.recipe_Id = recipe_Id;
	}

	public String getRecipe_Name() {
		return recipe_Name;
	}

	public void setRecipe_Name(String recipe_Name) {
		this.recipe_Name = recipe_Name;
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
		return "Recipe [recipe_Id=" + recipe_Id + ", recipe_Name=" + recipe_Name 
				+ ", price=" + price + ", restaurant=" + restaurant + "]";
	}
}
