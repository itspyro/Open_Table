package com.example.opentable.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.repository.RoleRepository;
import com.example.opentable.repository.entity.Role;
import com.example.opentable.service.RoleService;
import com.example.opentable.transport.RoleDetailsRequestResponse;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	@Autowired 
	RoleRepository roleRepository;
	
	@Autowired 
	RoleService roleService;

	
	@GetMapping("/")
	public RoleDetailsRequestResponse getAllRoles() {
		RoleDetailsRequestResponse response=null;
		try {
		    response=roleService.getRoles();
		    //System.out.println(response);
		} catch (Exception e) {
			
			response = new RoleDetailsRequestResponse();
			response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
		return response;
	}
	
	@PostMapping("/create")
	public String createRole(@RequestBody Role role) {
	    roleRepository.save(role);
	    return "Role Created";
	}
	
	@GetMapping("/{id}")
	public Optional<Role> findByID(@PathVariable(value = "id") int id) {
		return roleRepository.findById(id);
	}
	
}
