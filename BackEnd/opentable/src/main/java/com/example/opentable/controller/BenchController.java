package com.example.opentable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.repository.BenchRepository;
import com.example.opentable.repository.RestaurantRepository;
import com.example.opentable.repository.entity.Bench;
import com.example.opentable.repository.entity.Restaurant;

@RestController
@RequestMapping("/api")
public class BenchController {
	
	@Autowired 
	BenchRepository benche;
	
	@Autowired
	RestaurantRepository res;
	
	@GetMapping("/bench/all")
	public List<Bench> getAllBench(){
		return null;
	}
	
	@GetMapping("/bench")
	public List<Bench> getFreeBench(){
		return benche.findAll();
	}
	
	@GetMapping("/restaurant/{id}/bench/all")
	public List<Bench> getRestaurantBench(){
		return null;
	}
	
	@GetMapping("/restaurant/{id}/bench")
	public Bench findRestaurantBench() {
		return null;
	}
	
	@PostMapping("/{id}/bench/create")
	public void createBench(@PathVariable(value = "id") int id, @RequestBody Bench bench) {
		Restaurant restaurant = res.getById(id);
		bench.setRestaurant(restaurant);
		benche.save(bench);
	}
	
	@DeleteMapping("/restaurant/{id}/bench/delete/{id2}")
	public void deleteBench(@PathVariable(value = "id") int id, @PathVariable(value = "id2") int id2) {
		
	}
}
