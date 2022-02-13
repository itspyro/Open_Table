package com.example.opentable.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.repository.entity.Recipe;

@RestController
@RequestMapping("/api/restaurant/{id}/recipe")
public class RecipeController {
	
	@GetMapping("/")
	public List<Recipe> getAllRecipe(){
		return null;
	}
	
	@GetMapping("/{id2}")
	public Recipe getRecipe() {
		return null;
	}
	
	@PostMapping("/create/{id2}")
	public void createRecipe(@PathVariable(value = "id") int id, @PathVariable(value = "id2") int id2,@RequestBody Recipe recipe) {
		
	}
	
	@DeleteMapping("/delete/{id2}")
	public void deleteRecipe(@PathVariable(value = "id") int id, @PathVariable(value = "id2") int id2) {
		
	}
}
