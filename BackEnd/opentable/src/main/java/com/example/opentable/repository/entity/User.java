package com.example.opentable.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private int userId;
	
	@Column
	private String userName;
	
	@Column
	private String userPhoneNumber;
	
	@Column
	private String password;
	
	@Column
	private String userEmail;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;
	
	@OneToMany(mappedBy = "owner")
	private List<Restaurant> restaurants = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Booking> booking = new ArrayList<>();
	
	public User() {
	}

	public User(String userName, String userPhoneNumber, String password, String userEmail, Role role) {
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.password = password;
		this.userEmail = userEmail;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPhoneNumber=" + userPhoneNumber + ", password=" + password
				+ ", userEmail=" + userEmail + "]";
	}
	
}
