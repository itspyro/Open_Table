package com.example.opentable.repository.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cuisines")
public class Cuisine {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private int cuisine_Id;
	

	@Column 
	private String cuisine_Name;
	
	@ManyToMany(mappedBy = "cuisines")
    private List<Restaurant> restaurants = new ArrayList<>();
	
	public Cuisine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cuisine(int cuisine_Id, String cuisine_Name, List<Restaurant> restaurants) {
		super();
		this.cuisine_Id = cuisine_Id;
		this.cuisine_Name = cuisine_Name;
		this.restaurants = restaurants;
	}

	public int getCuisine_Id() {
		return cuisine_Id;
	}

	public void setCuisine_Id(int cuisine_Id) {
		this.cuisine_Id = cuisine_Id;
	}

	public String getCuisine_Name() {
		return cuisine_Name;
	}

	public void setCuisine_Name(String cuisine_Name) {
		this.cuisine_Name = cuisine_Name;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	@Override
	public String toString() {
		return "Cuisine [cuisine_Id=" + cuisine_Id + ", cuisine_Name=" 
				+ cuisine_Name + ", restaurants=" + restaurants
				+ "]";
	}

}
