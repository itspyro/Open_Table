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
	private int cuisineId;

	@Column 
	private String cuisineName;
	
	@ManyToMany(mappedBy = "cuisines")
    private List<Restaurant> restaurants = new ArrayList<>();
	
	public Cuisine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cuisine(int cuisineId, String cuisineName, List<Restaurant> restaurants) {
		super();
		this.cuisineId = cuisineId;
		this.cuisineName = cuisineName;
		this.restaurants = restaurants;
	}

	public int getCuisineId() {
		return cuisineId;
	}

	public void setCuisineId(int cuisineId) {
		this.cuisineId = cuisineId;
	}

	public String getCuisineName() {
		return cuisineName;
	}

	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	
}
