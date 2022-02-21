package com.example.opentable.transport.dto;

import java.util.List;

public class CuisineListDto {
	List<Integer> cuisineIds;

	public CuisineListDto() {
		super();
	}

	public CuisineListDto(List<Integer> cuisineIds) {
		this.cuisineIds = cuisineIds;
	}

	public List<Integer> getCuisineIds() {
		return cuisineIds;
	}

	public void setCuisineIds(List<Integer> cuisineIds) {
		this.cuisineIds = cuisineIds;
	}
}
