package com.example.opentable.transport.dto;



public class RestaurantDto {
	
	private int restaurantId;

	private String restaurantName;

	private AddressDto address;

	private String gstIn;

	private String contact;
	
	private boolean nonVeg;

	private String description;
	
	private String openingTime;
	 
	private String closingTime;
	
	public String getThumbnailPhoto() {
		return thumbnailPhoto;
	}



	public void setThumbnailPhoto(String thumbnailPhoto) {
		this.thumbnailPhoto = thumbnailPhoto;
	}



	private String thumbnailPhoto;
	
	
	
	private int rating;



	public RestaurantDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	



	public RestaurantDto(int restaurantId, String restaurantName, AddressDto address, String gstIn, String contact,
			boolean nonVeg, String description, String openingTime, String closingTime, String thumbnailPhoto,
			int rating) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.gstIn = gstIn;
		this.contact = contact;
		this.nonVeg = nonVeg;
		this.description = description;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.thumbnailPhoto = thumbnailPhoto;
		this.rating = rating;
	}



	public int getRestaurantId() {
		return restaurantId;
	}



	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}



	public String getRestaurantName() {
		return restaurantName;
	}



	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}



	public AddressDto getAddress() {
		return address;
	}



	public void setAddress(AddressDto address) {
		this.address = address;
	}



	public String getGstIn() {
		return gstIn;
	}



	public void setGstIn(String gstIn) {
		this.gstIn = gstIn;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public boolean isNonVeg() {
		return nonVeg;
	}



	public void setNonVeg(boolean nonVeg) {
		this.nonVeg = nonVeg;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getOpeningTime() {
		return openingTime;
	}



	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}



	public String getClosingTime() {
		return closingTime;
	}



	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}

	
	
	
}
