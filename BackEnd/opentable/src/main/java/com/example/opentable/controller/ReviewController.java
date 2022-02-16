package com.example.opentable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.repository.RestaurantRepository;
import com.example.opentable.repository.ReviewRepository;
import com.example.opentable.repository.UserRepository;
import com.example.opentable.repository.entity.Restaurant;
import com.example.opentable.repository.entity.Review;
import com.example.opentable.repository.entity.User;

@RestController
@RequestMapping("api/review")
public class ReviewController {
	
	@Autowired 
	ReviewRepository reviews;
	
	@Autowired
	UserRepository users;
	
	@Autowired
	RestaurantRepository res;
	
	@GetMapping("/")
	public List<Review> getAllReviews(){
		return reviews.findAll();
	}
	
	@GetMapping("/{id}")
	public Review getReviewDetail() {
		return null;
	}
	
	@PostMapping("/{ide}/create/{id}")
	public void createReview(@PathVariable(value = "id") int id,@PathVariable(value = "ide") int ide,@RequestBody Review review) {
		User user = (User) users.getById(ide);
		Restaurant restaurant = res.getById(id);
		review.setUser(user);
		review.setRestaurant(restaurant);
		reviews.save(review);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteReview(@PathVariable(value = "id") int id) {
		
	}
	
}
