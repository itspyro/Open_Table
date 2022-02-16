package com.example.opentable.transport.dto;

import java.util.Date;


public class ReviewDto {
	
	private int reviewId;

	private String review;

	private int rating;

	private Date timestamp;
	
	private UserDto user;

	private RestaurantDto restaurant;

	public ReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewDto(int reviewId, String review, int rating, Date timestamp, UserDto user, RestaurantDto restaurant) {
		super();
		this.reviewId = reviewId;
		this.review = review;
		this.rating = rating;
		this.timestamp = timestamp;
		this.user = user;
		this.restaurant = restaurant;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public RestaurantDto getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDto restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
