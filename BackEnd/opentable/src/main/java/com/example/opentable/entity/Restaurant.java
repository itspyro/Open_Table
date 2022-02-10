package com.example.opentable.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "restaurants")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restId;
	
	@Column
	private String restName;
	
	@Column
	private String restAddress;
	
	@Column
	private String restGstin;
	
	@Column 
	private String restContact;
	
	@Column
	private String restPreference;
	
	@Column
	private String restDescription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id")
	@JsonIgnore
	private User owner;

	public Restaurant() {
	}

	public Restaurant(String restName, String restAddress, String restGstin, String restContact, String restPreference,
			String restDescription, User owner) {
		this.restName = restName;
		this.restAddress = restAddress;
		this.restGstin = restGstin;
		this.restContact = restContact;
		this.restPreference = restPreference;
		this.restDescription = restDescription;
		this.owner = owner;
	}

	public int getRestId() {
		return restId;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getRestAddress() {
		return restAddress;
	}

	public void setRestAddress(String restAddress) {
		this.restAddress = restAddress;
	}

	public String getRestGstin() {
		return restGstin;
	}

	public void setRestGstin(String restGstin) {
		this.restGstin = restGstin;
	}

	public String getRestContact() {
		return restContact;
	}

	public void setRestContact(String restContact) {
		this.restContact = restContact;
	}

	public String getRestPreference() {
		return restPreference;
	}

	public void setRestPreference(String restPreference) {
		this.restPreference = restPreference;
	}

	public String getRestDescription() {
		return restDescription;
	}

	public void setRestDescription(String restDescription) {
		this.restDescription = restDescription;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Restaurant [restId=" + restId + ", restName=" + restName + ", restAddress=" + restAddress
				+ ", restGstin=" + restGstin + ", restContact=" + restContact + ", restPreference=" + restPreference
				+ ", restDescription=" + restDescription + ", owner=" + owner + "]";
	}
	
	
}
