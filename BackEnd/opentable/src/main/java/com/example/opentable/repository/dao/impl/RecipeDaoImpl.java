package com.example.opentable.repository.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.RecipeDao;
import com.example.opentable.repository.dao.Utilities;
import com.example.opentable.repository.entity.Recipe;
import com.example.opentable.repository.entity.Restaurant;
import com.example.opentable.transport.dto.CreateRecipeDto;
import com.example.opentable.transport.dto.RecipeDto;

@Repository
public class RecipeDaoImpl extends AbstractParentDao<Recipe> implements RecipeDao{

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int createRecipe(CreateRecipeDto createRecipeDto) throws Exception {
		int id;
		try {
			Recipe recipe = Utilities.convertDtoIntoRecipe(createRecipeDto);
			
			Restaurant restaurant = getEntityManager().getReference(Restaurant.class, createRecipeDto.getRestaurantId());
			recipe.setRestaurant(restaurant);
			getEntityManager().persist(recipe);
			
			id = recipe.getRecipeId();
			
			return id;
		} 
		catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<RecipeDto> getRestaurantRecipes(int restaurantId) throws Exception {
		List<Recipe> recipes = null;
		try {
			Query query = getEntityManager().createQuery("Select r.recipes from Restaurant r where r.restaurantId = :id").setParameter("id", restaurantId);
			recipes = query.getResultList();
			return convertRecipeIntoDto(recipes);
		}
		catch(Exception e) {
			throw e;
		}
	}

	private List<RecipeDto> convertRecipeIntoDto(List<Recipe> recipes) throws Exception {
		List<RecipeDto> recipeDtos = new ArrayList<>();
		try {
			if(recipes != null && recipes.isEmpty()==false) {
				for(Recipe recipe : recipes) {
					RecipeDto recipeDto = Utilities.convertRecipeIntoDto(recipe);
					recipeDtos.add(recipeDto);
				}
			}
		}
		catch(Exception e) {
			throw e;
		}
		return recipeDtos;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteRecipe(int recipeId) throws Exception {
		int numberOfEntityDeleted = 0;
		try {
	        Query query = getEntityManager().createQuery("delete from Recipe r where r.recipeId = :id").setParameter("id",recipeId);
	        numberOfEntityDeleted = query.executeUpdate();
			return numberOfEntityDeleted;
		}
		catch (Exception e) {
			throw e;
		}
		
	}
	
}
