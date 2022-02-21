package com.example.opentable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.ReviewDao;
import com.example.opentable.service.ReviewService;
import com.example.opentable.transport.dto.CreateReviewDto;
import com.example.opentable.transport.dto.ReviewDetailDto;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewDao reviewDao;

	@Override
	public List<ReviewDetailDto> getAllReviews() throws Exception {
		return reviewDao.getAllReviews();
	}

	@Override
	public List<ReviewDetailDto> getReviewsById(int reviewId) throws Exception {
		return reviewDao.getReviewsById(reviewId);
	}

	@Override
	public List<ReviewDetailDto> getReviewsByRestaurants(int restaurantId) throws Exception {
		return reviewDao.getReviewsByRestaurants(restaurantId);
	}

	@Override
	public int createReview(CreateReviewDto reviewDto) throws Exception {
		return reviewDao.createReview(reviewDto);
	}
	
	
	
}
