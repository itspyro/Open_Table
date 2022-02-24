package com.example.opentable.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.opentable.service.ReviewService;
import com.example.opentable.transport.ResponseMessage;
import com.example.opentable.transport.ReviewDetailsResponse;
import com.example.opentable.transport.dto.CreateReviewDto;

@RestController
@RequestMapping("api/review")
public class ReviewController {
	
	@Autowired 
	ReviewService reviewService;
	
	@GetMapping("/")
	public ResponseEntity<ReviewDetailsResponse> getAllReviews(){
		ReviewDetailsResponse response = new ReviewDetailsResponse();
		try {
			response.setReviews(reviewService.getAllReviews());
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successfull");
		}
		catch(Exception e) {
			response.setResponseMessage(e.getMessage());
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setReviews(null);
		}
		return new ResponseEntity<ReviewDetailsResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ReviewDetailsResponse> getReviewDetail(@PathVariable(value = "id") int reviewId) {
		ReviewDetailsResponse response = new ReviewDetailsResponse();
		try {
			response.setReviews(reviewService.getReviewsById(reviewId));
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successfull");
		}
		catch(Exception e) {
			response.setResponseMessage(e.getMessage());
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setReviews(null);
		}
		return new ResponseEntity<ReviewDetailsResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping("/restaurant/{id}")
	public ResponseEntity<ReviewDetailsResponse> getReviewByRestaurant(@PathVariable(value = "id") int restaurantId) {
		ReviewDetailsResponse response = new ReviewDetailsResponse();
		try {
			response.setReviews(reviewService.getReviewsByRestaurants(restaurantId));
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successfull");
		}
		catch(Exception e) {
			response.setResponseMessage(e.getMessage());
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setReviews(null);
		}
		return new ResponseEntity<ReviewDetailsResponse>(response, HttpStatus.OK);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> createReview(@RequestBody CreateReviewDto reviewDto) {
		ResponseMessage response = new ResponseMessage();
		try {
			response.setResponseMessage(String.format("Review with Id %d is created", reviewService.createReview(reviewDto)));
			response.setHttpStatusCode(HttpStatus.OK.value());
		}
		catch(Exception e) {
			response.setResponseMessage(e.getMessage());
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteReview(@PathVariable(value = "id") int reviewId) {
		ResponseMessage response = new ResponseMessage();
		try {
			int no = reviewService.deleteReview(reviewId);
			if(no >=1) {
				response.setResponseMessage("Review deleted");
			}
			else {
				response.setResponseMessage("Review not deleted");
			}
			response.setHttpStatusCode(HttpStatus.OK.value());
		}
		catch(Exception e) {
			response.setResponseMessage(e.getMessage());
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
	}
	
}
