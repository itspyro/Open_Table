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
@Table(name = "photos")
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private int photo_Id;
	
	@Column
	private String photo_Url;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_Id")
	private Restaurant restaurant;

	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Photo(int photo_Id, String photo_Url, Restaurant restaurant) {
		super();
		this.photo_Id = photo_Id;
		this.photo_Url = photo_Url;
		this.restaurant = restaurant;
	}

	public int getPhoto_Id() {
		return photo_Id;
	}

	public void setPhoto_Id(int photo_Id) {
		this.photo_Id = photo_Id;
	}

	public String getPhoto_Url() {
		return photo_Url;
	}

	public void setPhoto_Url(String photo_Url) {
		this.photo_Url = photo_Url;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Photo [photo_Id=" + photo_Id + ", photo_Url=" + photo_Url + ", restaurant=" + restaurant + "]";
	}
	
}
