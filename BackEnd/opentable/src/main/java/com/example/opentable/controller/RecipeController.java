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

import com.example.opentable.repository.RecipeRepository;
import com.example.opentable.repository.RestaurantRepository;
import com.example.opentable.repository.entity.Recipe;
import com.example.opentable.repository.entity.Restaurant;

@RestController
@RequestMapping("/api/restaurant/{id}/recipe")
public class RecipeController {
	
	@Autowired
	RecipeRepository reciper;
	
	@Autowired
	RestaurantRepository restaurant;
	
	@GetMapping("/")
	public List<Recipe> getAllRecipe(){
		return reciper.findAll();
	}
	
	@GetMapping("/{id2}")
	public Recipe getRecipe() {
		return null;
	}
	
	@PostMapping("/create/{id2}")
	public void createRecipe(@PathVariable(value = "id") int id, @RequestBody Recipe recipe) {
		Restaurant res = restaurant.getById(id);
		recipe.setRestaurant(res);
		reciper.save(recipe);
	}
	
	@DeleteMapping("/delete/{id2}")
	public void deleteRecipe(@PathVariable(value = "id") int id, @PathVariable(value = "id2") int id2) {
		
	}
}
