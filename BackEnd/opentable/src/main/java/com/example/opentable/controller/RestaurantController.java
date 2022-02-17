package com.example.opentable.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.service.RestaurantService;
import com.example.opentable.transport.ResponseMessage;
import com.example.opentable.transport.RestaurantDetailsResponse;
import com.example.opentable.transport.dto.RestaurantDto;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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
	
	@GetMapping("/{id}")
	public ResponseEntity<RestaurantDetailsResponse> getRestaurantById(@PathVariable(value = "id") int restaurantId) {
		RestaurantDetailsResponse response = new RestaurantDetailsResponse();
		try {
			response.setRestaurants(restaurantService.getRestaurantById(restaurantId));
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successful");
		}
		catch(Exception e) {
			response.setRestaurants(null);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
		return new ResponseEntity<RestaurantDetailsResponse>(response, HttpStatus.OK);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> createRestaurant(@RequestBody RestaurantDto restaurantDto){
		ResponseMessage response = new ResponseMessage();
		try {
			int restaurantId = restaurantService.createRestaurant(restaurantDto);
			response.setResponseMessage(String.format("Role with id %d created successfully",restaurantId));
			response.setHttpStatusCode(HttpStatus.OK.value());
		}
		catch(Exception e) {
			response.setResponseMessage(String.format(e.getMessage()));
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<ResponseMessage>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
	}
	
	
	
}
