package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.ReviewDetailDto;


public class ReviewDetailsResponse extends ResponseMessage implements Serializable{

	private static final long serialVersionUID = -6937086767480302289L;

	private List<ReviewDetailDto> reviews;

	public ReviewDetailsResponse() {

	}

	public List<ReviewDetailDto> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDetailDto> list) {
		this.reviews = list;
	}
	
	
	
}
