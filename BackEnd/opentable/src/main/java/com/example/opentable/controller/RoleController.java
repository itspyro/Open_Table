package com.example.opentable.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.entity.Role;
import com.example.opentable.repository.RoleRepository;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	@Autowired 
	RoleRepository roleRepository;
	
	@GetMapping("/")
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
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
