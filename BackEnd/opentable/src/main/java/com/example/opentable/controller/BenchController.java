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

import com.example.opentable.repository.entity.Bench;
import com.example.opentable.service.BenchService;
import com.example.opentable.transport.BenchDetailsResponse;
import com.example.opentable.transport.ResponseMessage;
import com.example.opentable.transport.dto.CreateBenchDto;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/bench")
public class BenchController {
	
	@Autowired
	BenchService benchService;
	
	
	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> createRecipe(@RequestBody CreateBenchDto createBenchDto) {
		String benchId;
		ResponseMessage response = new ResponseMessage();
	    try {
			benchId = benchService.createBench(createBenchDto);
			response.setResponseMessage("Bench with ids"+benchId+"created successfully");
			response.setHttpStatusCode(HttpStatus.OK.value());
			
		} catch (Exception e) {
			
			response.setResponseMessage(String.format(e.getMessage()));
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<ResponseMessage>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);
	}
	
	@GetMapping("/restaurant/{id}")
	public ResponseEntity<BenchDetailsResponse> getRestaurantBenches(@PathVariable(value = "id") int restaurantId){
		BenchDetailsResponse response = new BenchDetailsResponse();
		try {
			response.setBenches(benchService.getRestaurantBenches(restaurantId));
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successfull");
		}
		catch(Exception e) {
			response.setBenches(null);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
		return new ResponseEntity<BenchDetailsResponse>(response, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseMessage> updateBench(@RequestBody CreateBenchDto benchDto) {
		ResponseMessage response = new ResponseMessage();
	    try {
	    	int benchId = benchService.updateBench(benchDto);
	    	
	    	if(benchId==0) {
	    		response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
	    		response.setResponseMessage(String.format("Bench with id %d not found",benchId));
	    	}
	    	else {
	    		response.setHttpStatusCode(HttpStatus.OK.value());
	    		response.setResponseMessage(String.format("Bench with id %d updated successfully",benchId));
	    	}
			
		} catch (Exception e) {
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
	    return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteBench(@PathVariable(value = "id") int benchId) {
		int numberOfEntityDeleted = 0;
		ResponseMessage response = new ResponseMessage();
	    try {
	    	numberOfEntityDeleted = benchService.deleteBench(benchId);
	    	
	    	if(numberOfEntityDeleted==0) {
	    		response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
	    		response.setResponseMessage(String.format("Bench with id %d not found",benchId));
	    	}
	    	else {
	    		response.setHttpStatusCode(HttpStatus.OK.value());
	    		response.setResponseMessage(String.format("Bench with id %d deleted successfully",benchId));
	    	}
			
		} catch (Exception e) {
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
	    return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);
	}
}
