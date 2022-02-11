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

import com.example.opentable.entity.Restaurant;
import com.example.opentable.entity.User;
import com.example.opentable.repository.RestaurantRepository;
import com.example.opentable.repository.UserRepository;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}
	
	@PostMapping("/create/{id}")
	public String createRestaurant(@PathVariable(value = "id") int id,@RequestBody Restaurant restaurant) {
		User owner = userRepository.getById(id);
		restaurant.setOwner(owner);
		restaurantRepository.save(restaurant);
		return "Restaurent Created";
	}
	
	@GetMapping("/{id}")
	public Optional<Restaurant> findById(@PathVariable(value = "id") int id) {
		return restaurantRepository.findById(id);
	}
	
}
