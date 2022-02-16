package com.example.opentable.transport.dto;

public class PhotoDto {
	
	private int photoId;
	
	private String photoUrl;

	private RestaurantDto restaurant;

	public PhotoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhotoDto(int photoId, String photoUrl, RestaurantDto restaurant) {
		super();
		this.photoId = photoId;
		this.photoUrl = photoUrl;
		this.restaurant = restaurant;
	}

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public RestaurantDto getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDto restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
