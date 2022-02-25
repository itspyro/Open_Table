package com.example.opentable.transport.dto;

import java.util.List;

public class FilterDto {
	private List<Integer> cuisineIds;
	
	private String city;
	
	
	public List<Integer> getCuisineIds() {
		return cuisineIds;
	}
	public void setCuisineIds(List<Integer> cuisineIds) {
		this.cuisineIds = cuisineIds;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public FilterDto(List<Integer> cuisineIds, String city) {
		super();
		this.cuisineIds = cuisineIds;
		this.city = city;
	}
	public FilterDto() {
		super();
	}
	

}
