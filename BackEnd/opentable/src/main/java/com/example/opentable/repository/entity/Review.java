package com.example.opentable.repository.entity;

import java.util.Date;

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
@Table(name = "reviews")
public class Review {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private int review_Id;
	
	@Column 
	private String review;
	
	@Column 
	private int rating;
	
	@Column
	private Date timestamp;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_Id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "restaurant_Id")
	private Restaurant restaurant;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int review_Id, String review, int rating, Date timestamp, User user, Restaurant restaurant) {
		super();
		this.review_Id = review_Id;
		this.review = review;
		this.rating = rating;
		this.timestamp = timestamp;
		this.user = user;
		this.restaurant = restaurant;
	}

	public int getReview_Id() {
		return review_Id;
	}

	public void setReview_Id(int review_Id) {
		this.review_Id = review_Id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Review [review_Id=" + review_Id + ", review=" + review + ", rating=" + rating + ", timestamp="
				+ timestamp + ", user=" + user + ", restaurant=" + restaurant + "]";
	}
	
}
