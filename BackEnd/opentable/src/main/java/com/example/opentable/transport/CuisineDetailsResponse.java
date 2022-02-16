package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.CuisineDto;

public class CuisineDetailsResponse extends ResponseMessage implements Serializable{

	private static final long serialVersionUID = -7148665318012969402L;

	private List<CuisineDto> cuisines;

	public CuisineDetailsResponse() {

	}

	public List<CuisineDto> getCuisines() {
		return cuisines;
	}

	public void setCuisines(List<CuisineDto> cuisines) {
		this.cuisines = cuisines;
	}
	
	
}
