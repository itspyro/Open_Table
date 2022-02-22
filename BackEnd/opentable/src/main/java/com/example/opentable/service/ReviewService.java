package com.example.opentable.service;

import java.util.List;

import com.example.opentable.transport.dto.CreateReviewDto;
import com.example.opentable.transport.dto.ReviewDetailDto;

public interface ReviewService {
	public List<ReviewDetailDto> getAllReviews() throws Exception;
	
	public List<ReviewDetailDto> getReviewsById(int reviewId) throws Exception;
	
	public List<ReviewDetailDto> getReviewsByRestaurants(int restaurantId) throws Exception;
	
	public int createReview(CreateReviewDto reviewDto) throws Exception;
}
