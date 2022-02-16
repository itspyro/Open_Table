package com.example.opentable.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.service.RestaurantService;
import com.example.opentable.transport.RestaurantDetailsResponse;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	
	@GetMapping("/all")
	public ResponseEntity<RestaurantDetailsResponse> getAllRestaurants() {
		RestaurantDetailsResponse response = new RestaurantDetailsResponse();
		try {
			response.setRestaurants(restaurantService.getRestaurants());
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successful");
			
		} catch (Exception e) {
			response.setRestaurants(null);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
		return new ResponseEntity<RestaurantDetailsResponse>(response,HttpStatus.OK);
	}
	
	
	
}
