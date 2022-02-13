package com.example.opentable.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.repository.entity.Review;

@RestController
@RequestMapping("api/review")
public class ReviewController {
	
	@GetMapping("/")
	public List<Review> getAllReviews(){
		return null;
	}
	
	@GetMapping("/{id}")
	public Review getReviewDetail() {
		return null;
	}
	
	@PostMapping("/create/{id}")
	public void createReview(@PathVariable(value = "id") int id,@RequestBody Review review) {
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteReview(@PathVariable(value = "id") int id) {
		
	}
	
}
