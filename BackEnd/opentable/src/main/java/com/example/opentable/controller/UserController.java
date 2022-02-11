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
import com.example.opentable.entity.User;
import com.example.opentable.repository.RoleRepository;
import com.example.opentable.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/create")
	public String createUser(@RequestBody User user) {
		Role role = roleRepository.findById(user.getRole().getRoleId()).get();
		user.setRole(role);
	    userRepository.save(user);
	    return "User Created";
	}
	
	@GetMapping("/{id}")
	public Optional<User> findByID(@PathVariable(value = "id") int id) {
		return userRepository.findById(id);
	}
	
}
