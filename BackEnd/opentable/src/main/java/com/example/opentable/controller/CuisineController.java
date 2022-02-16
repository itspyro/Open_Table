package com.example.opentable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.repository.CuisineRepository;
import com.example.opentable.repository.entity.Cuisine;
import com.example.opentable.repository.entity.Restaurant;

@RestController
@RequestMapping("/api/cuisines")
public class CuisineController {
	
	@Autowired
	CuisineRepository cuisineRepository;
	
	@GetMapping("/")
	public List<Cuisine> getAllCuisines(){
		return cuisineRepository.findAll();
	}
	
	@PostMapping("/create")
	public String createCuisine(@RequestBody Cuisine cuisine) {
		cuisineRepository.save(cuisine);
		return "Cuisine Created";
	}
	
	@GetMapping("/{id}")
	public List<Restaurant> getCuisineRestaurant(){
		return null;
	}
}
