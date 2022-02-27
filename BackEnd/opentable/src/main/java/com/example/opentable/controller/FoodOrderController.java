package com.example.opentable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.service.FoodOrderService;
import com.example.opentable.transport.FoodOrderDetailsResponse;
import com.example.opentable.transport.ResponseMessage;
import com.example.opentable.transport.dto.FoodOrderDto;

@RestController
@RequestMapping("/api/foodorder")
public class FoodOrderController 
{

	@Autowired
	FoodOrderService foodOrderService;
		
		
	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> createFoodOrder(@RequestBody FoodOrderDto foodOrderDto)
	{
		List<Integer> foodOrderIds;
		ResponseMessage response = new ResponseMessage();
		try
		{
			foodOrderIds = foodOrderService.createFoodOrder(foodOrderDto);
			response.setResponseMessage(String.format("list of foodorder with foodorder is created"));
			response.setHttpStatusCode(HttpStatus.OK.value());
		}
		
		catch(Exception e)
		{
			response.setResponseMessage(e.getMessage());
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<ResponseMessage> (response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return  new ResponseEntity<ResponseMessage> (response,HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FoodOrderDetailsResponse> getFoodOrderByBooking(@PathVariable(value = "id") int bookingId)
	{
		FoodOrderDetailsResponse response = new FoodOrderDetailsResponse();
		try
		{
			response.setFoodOrders(foodOrderService.getFoodOrderByBooking(bookingId));
			response.setResponseMessage("succesful");
			response.setHttpStatusCode(HttpStatus.OK.value());
		}
		
		catch(Exception e)
		{
			response.setFoodOrders(null);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
			
		return new ResponseEntity<FoodOrderDetailsResponse>(response,HttpStatus.OK);
	}

}


