package com.example.opentable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.repository.entity.Recipe;
import com.example.opentable.service.RecipeService;
import com.example.opentable.transport.RecipeDetailsResponse;
import com.example.opentable.transport.ResponseMessage;
import com.example.opentable.transport.dto.CreateRecipeDto;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	@GetMapping("/")
	public List<Recipe> getAllRecipe(){
		return null;
	}
	
	@GetMapping("/{id}")
	public Recipe getRecipe() {
		return null;
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> createRecipe(@RequestBody CreateRecipeDto createRecipeDto) {
		int recipeId;
		ResponseMessage response = new ResponseMessage();
	    try {
			recipeId = recipeService.createRecipe(createRecipeDto);
			response.setResponseMessage(String.format("Recipe with id %d created successfully",recipeId));
			response.setHttpStatusCode(HttpStatus.OK.value());
			
		} catch (Exception e) {
			
			response.setResponseMessage(String.format(e.getMessage()));
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<ResponseMessage>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseMessage> updateRecipe(@RequestBody CreateRecipeDto RecipeDto) {
		int recipeId;
		ResponseMessage response = new ResponseMessage();
	    try {
			recipeId = recipeService.updateRecipe(RecipeDto);
			response.setResponseMessage(String.format("Recipe with id %d updated successfully",recipeId));
			response.setHttpStatusCode(HttpStatus.OK.value());
			
		} catch (Exception e) {
			
			response.setResponseMessage(String.format(e.getMessage()));
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<ResponseMessage>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);
	}
	
	@GetMapping("/restaurant/{id}")
	public ResponseEntity<RecipeDetailsResponse> getRestaurantRecipes(@PathVariable(value = "id") int restaurantId){
		RecipeDetailsResponse response = new RecipeDetailsResponse();
		try {
			response.setRecipes(recipeService.getRestaurantRecipes(restaurantId));
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successfull");
		}
		catch(Exception e) {
			response.setRecipes(null);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
		return new ResponseEntity<RecipeDetailsResponse>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRecipe(@PathVariable(value = "id") int recipeId) {
		int numberOfEntityDeleted = 0;
		ResponseMessage response = new ResponseMessage();
	    try {
	    	numberOfEntityDeleted = recipeService.deleteRecipe(recipeId);
	    	
	    	if(numberOfEntityDeleted==0) {
	    		response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
	    		response.setResponseMessage(String.format("Recipe with id %d not found",recipeId));
	    	}
	    	else {
	    		response.setHttpStatusCode(HttpStatus.OK.value());
	    		response.setResponseMessage(String.format("Recipe with id %d deleted successfully",recipeId));
	    	}
			
		} catch (Exception e) {
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
	    return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);
	}
}
