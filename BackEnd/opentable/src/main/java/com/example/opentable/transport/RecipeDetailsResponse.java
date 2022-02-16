package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.RecipeDto;

public class RecipeDetailsResponse extends ResponseMessage implements Serializable {

	private static final long serialVersionUID = -2137212561797172573L;

	private List<RecipeDto> recipes;

	public RecipeDetailsResponse() {

	}

	public List<RecipeDto> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<RecipeDto> recipes) {
		this.recipes = recipes;
	}
	
	
}
