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
	private int bench_Id;
	
	@Column 
	private String bench_Type;

	@Column
	private int capacity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "restaurant_Id")
    private Restaurant restaurant;

	public Bench() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bench(int bench_Id, String bench_Type, int capacity, Restaurant restaurant) {
		super();
		this.bench_Id = bench_Id;
		this.bench_Type = bench_Type;
		this.capacity = capacity;
		this.restaurant = restaurant;
	}

	public int getBench_Id() {
		return bench_Id;
	}

	public void setBench_Id(int bench_Id) {
		this.bench_Id = bench_Id;
	}

	public String getBench_Type() {
		return bench_Type;
	}

	public void setBench_Type(String bench_Type) {
		this.bench_Type = bench_Type;
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

	@Override
	public String toString() {
		return "Bench [bench_Id=" + bench_Id + ", bench_Type=" + bench_Type + ", capacity=" + capacity + ", restaurant="
				+ restaurant + "]";
	}
	
}
