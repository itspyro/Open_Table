package com.example.opentable.service;

import java.util.List;

import com.example.opentable.transport.dto.CreateRecipeDto;
import com.example.opentable.transport.dto.RecipeDto;

public interface RecipeService {

	int createRecipe(CreateRecipeDto createRecipeDto) throws Exception;

	List<RecipeDto> getRestaurantRecipes(int restaurantId) throws Exception;

	int deleteRecipe(int recipeId) throws Exception;

}
