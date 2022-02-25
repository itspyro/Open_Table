package com.example.opentable.transport;

import java.util.List;

public class CityDetailResponse extends ResponseMessage {
	private List<String> cities;

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public CityDetailResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
