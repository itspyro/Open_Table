package com.example.opentable.repository.dao;

import java.util.List;

import com.example.opentable.transport.dto.CreateRecipeDto;
import com.example.opentable.transport.dto.RecipeDto;

public interface RecipeDao {

	int createRecipe(CreateRecipeDto createRecipeDto) throws Exception;

	List<RecipeDto> getRestaurantRecipes(int restaurantId) throws Exception;

	int deleteRecipe(int recipeId) throws Exception;
	
	int updateRecipe(CreateRecipeDto recipeDto) throws Exception;

}
