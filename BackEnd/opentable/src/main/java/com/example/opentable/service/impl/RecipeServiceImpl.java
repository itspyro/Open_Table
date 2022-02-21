package com.example.opentable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.RecipeDao;
import com.example.opentable.service.RecipeService;
import com.example.opentable.transport.dto.CreateRecipeDto;
import com.example.opentable.transport.dto.RecipeDto;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	RecipeDao recipeDao;
	
	@Override
	public int createRecipe(CreateRecipeDto createRecipeDto) throws Exception {
		
		return recipeDao.createRecipe(createRecipeDto);
	}

	@Override
	public List<RecipeDto> getRestaurantRecipes(int restaurantId) throws Exception {
		
		return recipeDao.getRestaurantRecipes(restaurantId);
	}

	@Override
	public int deleteRecipe(int recipeId) throws Exception {
		
		return recipeDao.deleteRecipe(recipeId);
	}

}
