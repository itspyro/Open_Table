package com.example.opentable.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.service.RoleService;
import com.example.opentable.transport.ResponseMessage;
import com.example.opentable.transport.RoleDetailsRequestResponse;
import com.example.opentable.transport.dto.RoleDto;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	@Autowired 
	RoleService roleService;

	
	@GetMapping("/all")
	public ResponseEntity<RoleDetailsRequestResponse> getAllRoles() {
		RoleDetailsRequestResponse response = new RoleDetailsRequestResponse();
		try {
		    response.setRoles(roleService.getRoles());
		    response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successful");
			
		} catch (Exception e) {
			response.setRoles(null);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
			
		}
		return new ResponseEntity<RoleDetailsRequestResponse>(response,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> createRole(@RequestBody RoleDto roleDto) {
		int roleId;
		ResponseMessage response = new ResponseMessage();
	    try {
	    	
			roleId = roleService.createRole(roleDto);
			response.setResponseMessage(String.format("Role with id %d created successfully",roleId));
			response.setHttpStatusCode(HttpStatus.OK.value());
			
		} catch (Exception e) {
			
			response.setResponseMessage(String.format(e.getMessage()));
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<ResponseMessage>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<RoleDetailsRequestResponse> findByID(@PathVariable(value = "id") int roleId) {
		RoleDetailsRequestResponse response = new RoleDetailsRequestResponse();
		try {
		    response.setRoles(roleService.findById(roleId));
		    
		    if(response.getRoles()==null || response.getRoles().isEmpty()) {
		    	response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
				response.setResponseMessage(String.format("Role with id %d not found",roleId));
		    }
		    else {
		    	response.setHttpStatusCode(HttpStatus.OK.value());
				response.setResponseMessage("Successful");
			}
			
		} catch (Exception e) {
			response.setRoles(null);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
			
		}
		return new ResponseEntity<RoleDetailsRequestResponse>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRole(@PathVariable(value = "id") int roleId) {
		int numberOfEntityDeleted = 0;
		ResponseMessage response = new ResponseMessage();
	    try {
	    	numberOfEntityDeleted = roleService.deleteRole(roleId);
	    	
	    	if(numberOfEntityDeleted==0) {
	    		response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
	    		response.setResponseMessage(String.format("Role with id %d not found",roleId));
	    	}
	    	else {
	    		response.setHttpStatusCode(HttpStatus.OK.value());
	    		response.setResponseMessage(String.format("Role with id %d deleted successfully",roleId));
	    	}
			
		} catch (Exception e) {
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
	    return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);
	}
}