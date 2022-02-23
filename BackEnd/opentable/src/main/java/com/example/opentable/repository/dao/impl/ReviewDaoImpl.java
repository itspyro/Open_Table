package com.example.opentable.repository.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.ReviewDao;
import com.example.opentable.repository.dao.Utilities;
import com.example.opentable.repository.entity.Restaurant;
import com.example.opentable.repository.entity.Review;
import com.example.opentable.repository.entity.User;
import com.example.opentable.transport.dto.CreateReviewDto;
import com.example.opentable.transport.dto.ReviewDetailDto;

@Repository
public class ReviewDaoImpl extends AbstractParentDao<Review> implements ReviewDao {

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<ReviewDetailDto> getAllReviews() throws Exception {
		try {
			List<Review> reviews = new ArrayList<>();
			Query query = getEntityManager().createQuery("select r from Review r");
			reviews = query.getResultList();
			return convertReviewIntoDto(reviews);
		}
		catch(Exception e) {
			throw e;
		}
	}

	private List<ReviewDetailDto> convertReviewIntoDto(List<Review> reviews) {
		List<ReviewDetailDto> reviewDtos = new ArrayList<>();
		try {
			if(reviews != null && reviews.isEmpty()==false) {
				for(Review review:reviews) {
					ReviewDetailDto reviewDto= Utilities.convertReviewIntoDto(review);
					reviewDto.setRestaurant(Utilities.convertRestaurantIntoDto(review.getRestaurant()));
					reviewDto.setUser(Utilities.convertUserIntoDto(review.getUser()));
					reviewDtos.add(reviewDto);
				}
			}
			return reviewDtos;
		}
		catch(Exception e) {
			throw e;
		}
	}

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<ReviewDetailDto> getReviewsById(int reviewId) throws Exception {
		try {
			List<Review> reviews = new ArrayList<>();
			Query query = getEntityManager().createQuery("select r from Review r where r.reviewId = :id").setParameter("id", reviewId);
			reviews = query.getResultList();
			return convertReviewIntoDto(reviews);
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<ReviewDetailDto> getReviewsByRestaurants(int restaurantId) throws Exception {
		try {
			List<Review> reviews = null;
			Query query = getEntityManager().createQuery("select r.reviews from Restaurant r where r.restaurantId = :id").setParameter("id", restaurantId);
			reviews = query.getResultList();
			return convertReviewIntoDto(reviews);
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int createReview(CreateReviewDto reviewDto) throws Exception {
		try {
			Review review = Utilities.convertDtoIntoReview(reviewDto);
			Restaurant restaurant = getEntityManager().getReference(Restaurant.class, reviewDto.getRestaurantId());
			User user = getEntityManager().getReference(User.class, reviewDto.getUserId());
			review.setUser(user);
			restaurant.setRatingSum(restaurant.getRatingSum()+ review.getRating());
			restaurant.setUsersRated(restaurant.getUsersRated() + 1);
			review.setRestaurant(restaurant);
			getEntityManager().merge(restaurant);
			save(review);
			return review.getReviewId();
		}
		catch(Exception e) {
			throw e;
		}
	}

	

}
