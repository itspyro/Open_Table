package com.example.opentable.transport.dto;

import java.util.List;


public class CuisineDto {
	
	private int cuisineId;

	private String cuisineName;
    

	public CuisineDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuisineDto(int cuisineId, String cuisineName) {
		super();
		this.cuisineId = cuisineId;
		this.cuisineName = cuisineName;
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
    
}
