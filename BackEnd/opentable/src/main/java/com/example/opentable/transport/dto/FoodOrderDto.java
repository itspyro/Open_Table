package com.example.opentable.transport.dto;

import java.util.List;

public class FoodOrderDto {
	
	private List<Intpair> recipies;
	

	
	private int bookingId;
	

	public FoodOrderDto() {
		super();
	}


	public List<Intpair> getRecipies() {
		return recipies;
	}


	public void setRecipies(List<Intpair> recipies) {
		this.recipies = recipies;
	}


	

	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	
	

}
