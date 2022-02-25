package com.example.opentable.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.service.RestaurantService;
import com.example.opentable.transport.ResponseMessage;
import com.example.opentable.transport.RestaurantDetailsResponse;
import com.example.opentable.transport.RestaurantListResponse;
import com.example.opentable.transport.dto.CreateRestaurantDto;
import com.example.opentable.transport.dto.CuisineListDto;
import com.example.opentable.transport.dto.RestaurantDetailDto;
import com.example.opentable.transport.dto.RestaurantDto;
import com.example.opentable.transport.dto.RestaurantUpdateDto;


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
			List<RestaurantDto> restaurants = restaurantService.getRestaurants();
			if(restaurants==null) {
				response.setRestaurants(restaurants);
				response.setResponseMessage("Not Found");
				response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			}
			else {
				response.setRestaurants(restaurants);
				response.setResponseMessage("Successfull");
				response.setHttpStatusCode(HttpStatus.OK.value());
			}
			
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
			RestaurantDetailDto restaurant = restaurantService.getRestaurantById(restaurantId);
			if(restaurant==null) {
				response.setRestaurant(restaurant);
				response.setResponseMessage("Not Found");
				response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			}
			else {
				response.setRestaurant(restaurant);
				response.setResponseMessage("Successfull");
				response.setHttpStatusCode(HttpStatus.OK.value());
			}
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
				response.setHttpStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			}
			else if(restaurantId == -2) {
				response.setResponseMessage("Restaurant cannot be created because user is not an owner");
				response.setHttpStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			}
			else {
				response.setResponseMessage(String.format("Restaurant with id %d created successfully",restaurantId));
				response.setHttpStatusCode(HttpStatus.OK.value());
			}
			
		}
		catch(Exception e) {
			response.setResponseMessage(String.format(e.getMessage()));
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/restaurant/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRestaurant(@PathVariable(value = "id") int restaurantId){
		ResponseMessage response = new ResponseMessage();
		try {
			if(restaurantService.deleteRestaurant(restaurantId)==1) {
				response.setResponseMessage("Restaurant deleted successfully");
				response.setHttpStatusCode(HttpStatus.OK.value());
			}
			else {
				response.setResponseMessage("Restaurant not deleted");
				response.setHttpStatusCode(HttpStatus.NO_CONTENT.value());
			}
			
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
			List<RestaurantDto> restaurants = restaurantService.getRestaurantByUser(userId);
			if(restaurants==null) {
				response.setRestaurants(restaurants);
				response.setResponseMessage("Not Found");
				response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			}
			else {
				response.setRestaurants(restaurants);
				response.setResponseMessage("Successfull");
				response.setHttpStatusCode(HttpStatus.OK.value());
			}
		}
		catch(Exception e) {
			response.setRestaurants(null);
			response.setResponseMessage(e.getMessage());
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return new ResponseEntity<RestaurantListResponse>(response, HttpStatus.OK);
		
	}
	
	@GetMapping("/cuisine/restaurant")
	public ResponseEntity<RestaurantListResponse> getRestaurantByCuisine(@RequestBody CuisineListDto cuisineIds){
		RestaurantListResponse response = new RestaurantListResponse();
		try {
			List<RestaurantDto> restaurants = restaurantService.getRestaurantByCuisine(cuisineIds);
			if(restaurants==null) {
				response.setRestaurants(restaurants);
				response.setResponseMessage("Not Found");
				response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			}
			else {
				response.setRestaurants(restaurants);
				response.setResponseMessage("Successfull");
				response.setHttpStatusCode(HttpStatus.OK.value());
			}
		}
		catch(Exception e) {
			response.setRestaurants(null);
			response.setResponseMessage(e.getMessage());
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return new ResponseEntity<RestaurantListResponse>(response, HttpStatus.OK);
	}
	
	@PutMapping("/restaurant/update")
	public ResponseEntity<ResponseMessage> updateRestaurant(@RequestBody RestaurantUpdateDto restaurantDto){
		ResponseMessage response = new ResponseMessage();
		try {
			int updateId= restaurantService.updateRestaurant(restaurantDto);
			if(updateId!=0) {
				response.setResponseMessage(String.format("Restaurant with id %d "
						+ "update successfully", updateId));
				response.setHttpStatusCode(HttpStatus.OK.value());
			}
			else {
				response.setResponseMessage("Restaurant not updated");
				response.setHttpStatusCode(HttpStatus.NOT_MODIFIED.value());
			}
		}
		catch(Exception e) {
			response.setResponseMessage(String.format(e.getMessage()));
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
	}
}
