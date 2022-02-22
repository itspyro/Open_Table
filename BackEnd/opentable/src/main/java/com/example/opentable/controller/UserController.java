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

import com.example.opentable.repository.UserRepository;
import com.example.opentable.repository.entity.User;
import com.example.opentable.service.UserService;
import com.example.opentable.transport.ResponseMessage;
import com.example.opentable.transport.UserDetailsResponse;
import com.example.opentable.transport.dto.CreateUserDto;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> createUser(@RequestBody CreateUserDto createUserDto) {
		int userId;
		ResponseMessage response = new ResponseMessage();
	    try {
			userId = userService.createUser(createUserDto);
			response.setResponseMessage(String.format("User with id %d created successfully",userId));
			response.setHttpStatusCode(HttpStatus.OK.value());
			
		} catch (Exception e) {
			
			response.setResponseMessage(String.format(e.getMessage()));
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<ResponseMessage>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);
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
