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
import com.example.opentable.transport.RestaurantListResponse;
import com.example.opentable.transport.dto.CreateRestaurantDto;
import com.example.opentable.transport.dto.CuisineListDto;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	
	@GetMapping("/restaurant/all")
	public ResponseEntity<RestaurantListResponse> getAllRestaurants() {
		RestaurantListResponse response = new RestaurantListResponse();
		try {
			response.setRestaurants(restaurantService.getRestaurants());
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successful");
			
		} catch (Exception e) {
			response.setRestaurants(null);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
		return new ResponseEntity<RestaurantListResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/restaurant/{id}")
	public ResponseEntity<RestaurantDetailsResponse> getRestaurantById(@PathVariable(value = "id") int restaurantId) {
		RestaurantDetailsResponse response = new RestaurantDetailsResponse();
		try {
			response.setRestaurant(restaurantService.getRestaurantById(restaurantId));
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successful");
		}
		catch(Exception e) {
			response.setRestaurant(null);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
		return new ResponseEntity<RestaurantDetailsResponse>(response, HttpStatus.OK);
		
	}
	
	@PostMapping("/restaurant/create")
	public ResponseEntity<ResponseMessage> createRestaurant(@RequestBody CreateRestaurantDto restaurantDto){
		ResponseMessage response = new ResponseMessage();
		try {
			int restaurantId = restaurantService.createRestaurant(restaurantDto);
			if(restaurantId == -1) {
				response.setResponseMessage("Restaurant cannot be created without user");
			}
			else if(restaurantId == -2) {
				response.setResponseMessage("Restaurant cannot be created because user is not an owner");
			}
			else {
				response.setResponseMessage(String.format("Restaurant with id %d created successfully",restaurantId));
			}
			response.setHttpStatusCode(HttpStatus.OK.value());
		}
		catch(Exception e) {
			response.setResponseMessage(String.format(e.getMessage()));
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
	}
	
	@GetMapping("/user/restaurant/{id}")
	public ResponseEntity<RestaurantListResponse> getRestaurantByUser(@PathVariable(value = "id") int userId){
		RestaurantListResponse response = new RestaurantListResponse();
		try {
			response.setRestaurants(restaurantService.getRestaurantByUser(userId));
			response.setResponseMessage("Successfull");
			response.setHttpStatusCode(HttpStatus.OK.value());
		}
		catch(Exception e) {
			response.setRestaurants(null);
			response.setResponseMessage(e.getMessage());
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return new ResponseEntity<RestaurantListResponse>(response, HttpStatus.OK);
		
	}
	
	@PostMapping("/cuisine/restaurant")
	public ResponseEntity<RestaurantListResponse> getRestaurantByCuisine(@RequestBody CuisineListDto cuisineIds){
		RestaurantListResponse response = new RestaurantListResponse();
		try {
			response.setRestaurants(restaurantService.getRestaurantByCuisine(cuisineIds));
			response.setResponseMessage("Successfull");
			response.setHttpStatusCode(HttpStatus.OK.value());
		}
		catch(Exception e) {
			response.setRestaurants(null);
			response.setResponseMessage(e.getMessage());
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return new ResponseEntity<RestaurantListResponse>(response, HttpStatus.OK);
	}
	
	
	
	
}
