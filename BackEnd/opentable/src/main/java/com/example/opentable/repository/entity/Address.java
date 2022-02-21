package com.example.opentable.repository.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String city;
	
	private String pincode;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String addressLine1, String addressLine2, String city, String pincode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.pincode = pincode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
