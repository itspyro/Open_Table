package com.example.opentable.controller;

import java.util.List;

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

import com.example.opentable.repository.entity.Cuisine;
import com.example.opentable.repository.entity.Restaurant;
import com.example.opentable.service.CuisineService;
import com.example.opentable.transport.CuisineDetailsResponse;
import com.example.opentable.transport.ResponseMessage;
import com.example.opentable.transport.dto.CuisineDto;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/cuisines")
public class CuisineController {
	
	@Autowired
	CuisineService cuisineService;
	
	@GetMapping("/")
	public ResponseEntity<CuisineDetailsResponse> getAllCuisines(){
		CuisineDetailsResponse response = new CuisineDetailsResponse();
		try {
			response.setCuisines(cuisineService.getAllCuisine());
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successfull");
		}
		catch(Exception e) {
			response.setCuisines(null);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
		return new ResponseEntity<CuisineDetailsResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> createCuisine(@RequestBody CuisineDto cuisineDto) {
		ResponseMessage response = new ResponseMessage();
		try {
			int cuisineId = cuisineService.createCuisine(cuisineDto);
			response.setResponseMessage(String.format("Cuisine with %d created", cuisineId));
			response.setHttpStatusCode(HttpStatus.OK.value());
		}
		catch(Exception e) {
			response.setResponseMessage(e.getMessage());
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return new ResponseEntity<ResponseMessage> (response, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CuisineDetailsResponse> getCuisineRestaurant(@PathVariable(value = "id") int restaurant_Id){
		CuisineDetailsResponse response = new CuisineDetailsResponse();
		try {
			response.setCuisines(cuisineService.getCuisineByRestaurant(restaurant_Id));
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successfull");
		}
		catch(Exception e) {
			response.setCuisines(null);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
		return new ResponseEntity<CuisineDetailsResponse>(response, HttpStatus.OK);
	}
}
