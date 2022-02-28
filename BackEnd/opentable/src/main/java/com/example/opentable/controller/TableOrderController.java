package com.example.opentable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.service.TableOrderService;
import com.example.opentable.transport.BenchDetailsResponse;
import com.example.opentable.transport.dto.CheckAvailabilityDto;

@RestController
@RequestMapping("api")
public class TableOrderController {

@Autowired
TableOrderService tableOrderService;
	
 @PostMapping("/checkAvailability/")
 public ResponseEntity<BenchDetailsResponse> checkAvailability (@RequestBody CheckAvailabilityDto checkAvailabilityDto)
 {
	 BenchDetailsResponse response = new BenchDetailsResponse();
	 
	 try
	 {
		 response.setBenches(tableOrderService.checkavailability(checkAvailabilityDto));
		 response.setHttpStatusCode(HttpStatus.OK.value());
		 response.setResponseMessage("successful");
	 }
	 
	 catch(Exception e)
	 {
		 response.setBenches(null);
		 response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		 response.setResponseMessage(e.getMessage());
	 }
	 
	 return new ResponseEntity<BenchDetailsResponse>(response,HttpStatus.OK);
 }

}
