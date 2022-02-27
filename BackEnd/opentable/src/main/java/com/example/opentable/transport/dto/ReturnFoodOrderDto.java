package com.example.opentable.transport.dto;

import java.util.List;

public class ReturnFoodOrderDto {

	private List<IntTrio> recipies;
	
	

	public ReturnFoodOrderDto() {
		super();
	}

	public List<IntTrio> getRecipies() {
		return recipies;
	}

	public void setRecipies(List<IntTrio> recipies) {
		this.recipies = recipies;
	}
	
	
}
