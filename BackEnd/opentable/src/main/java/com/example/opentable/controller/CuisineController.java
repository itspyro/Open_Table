package com.example.opentable.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.repository.entity.Cuisine;
import com.example.opentable.repository.entity.Restaurant;

@RestController
@RequestMapping("/api/cuisines")
public class CuisineController {
	@GetMapping("/")
	public List<Cuisine> getAllCuisines(){
		return null;
	}
	
	@PostMapping("/create")
	public void createCuisine(@RequestBody Cuisine cuisine) {
		
	}
	
	@GetMapping("/{id}")
	public List<Restaurant> getCuisineRestaurant(){
		return null;
	}
}
