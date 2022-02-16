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
@Table(name = "benches")
public class Bench {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private int benchId;
	
	@Column 
	private String benchType;

	@Column
	private int capacity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

	public Bench() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bench(int benchId, String benchType, int capacity, Restaurant restaurant) {
		super();
		this.benchId = benchId;
		this.benchType = benchType;
		this.capacity = capacity;
		this.restaurant = restaurant;
	}

	public int getBenchId() {
		return benchId;
	}

	public void setBenchId(int benchId) {
		this.benchId = benchId;
	}

	public String getBenchType() {
		return benchType;
	}

	public void setBenchType(String benchType) {
		this.benchType = benchType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	
}
