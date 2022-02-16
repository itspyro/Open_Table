package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.ReviewDto;

public class ReviewDetailsResponse extends ResponseMessage implements Serializable{

	private static final long serialVersionUID = -6937086767480302289L;

	private List<ReviewDto> reviews;

	public ReviewDetailsResponse() {

	}

	public List<ReviewDto> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDto> reviews) {
		this.reviews = reviews;
	}
	
	
	
}
