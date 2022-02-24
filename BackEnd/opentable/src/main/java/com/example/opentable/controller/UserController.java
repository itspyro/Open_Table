package com.example.opentable.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.service.RestaurantService;
import com.example.opentable.service.UserService;
import com.example.opentable.transport.LoginResponse;
import com.example.opentable.transport.ResponseMessage;
import com.example.opentable.transport.UserDetailsResponse;
import com.example.opentable.transport.dto.LoginDto;
import com.example.opentable.transport.dto.RegisterUserDto;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RestaurantService restaurantService;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> createUser(@Valid @RequestBody RegisterUserDto registerUserDto) {
		int userId;
		ResponseMessage response = new ResponseMessage();
	    try {
			userId = userService.createUser(registerUserDto);
			
			if(userId == -1) {
				response.setResponseMessage(String.format("Email '%s' already exists",registerUserDto.getUserEmail()));
				response.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
			}
			else if(userId == -2) {
				response.setResponseMessage(String.format("Role '%s' not found",registerUserDto.getRoleName()));
				response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			}
			else if(userId != 0){
				response.setResponseMessage(String.format("User with id %d created successfully",userId));
				response.setHttpStatusCode(HttpStatus.OK.value());
			}
			
		} catch (Exception e) {
			
			response.setResponseMessage(e.getMessage());
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<ResponseMessage>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginDto loginDto) {
		LoginResponse response = new LoginResponse();
		int userId;
		try {
			userId = userService.login(loginDto);
			
			if(userId == -1) {
				response.setUserId(0);
				response.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
				response.setResponseMessage("Wrong Password");
			}
			else if(userId == -2) {
				response.setUserId(0);
				response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
				response.setResponseMessage("Email not found");
			}
			else if(userId != 0){
				response.setUserId(userId);
				response.setHttpStatusCode(HttpStatus.OK.value());
				response.setResponseMessage("User logged in successfully");
			}
			
		} catch (Exception e) {
			response.setUserId(0);
			response.setResponseMessage(e.getMessage());
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<LoginResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<LoginResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<UserDetailsResponse> findByID(@PathVariable(value = "id") int userId) {
		UserDetailsResponse response = new UserDetailsResponse();
		try {
		    response.setUsers(userService.findById(userId));
		    
		    if(response.getUsers()==null || response.getUsers().isEmpty()) {
		    	response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
				response.setResponseMessage(String.format("User with id %d not found",userId));
		    }
		    else {
		    	response.setRestaurants(restaurantService.getRestaurantByUser(userId));
		    	response.setHttpStatusCode(HttpStatus.OK.value());
				response.setResponseMessage("Successful");
			}
		
		} catch (Exception e) {
			response.setUsers(null);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
			
		}
		return new ResponseEntity<UserDetailsResponse>(response,HttpStatus.OK);
	}
	
}
