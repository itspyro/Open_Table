package com.example.opentable.transport.dto;

import java.util.List;

public class RestaurantDetailDto extends RestaurantDto {
	
	private List<CuisineDto> cuisines;
	
	private UserDto user;
	
	private List<BenchDto> benches;
	
	private List<ReviewDto> reviews;
	
	private List<RecipeDto> recipeDto;
	
	private List<PhotoDto> photoDto;

	public RestaurantDetailDto() {
		super();
	}


	


	public List<PhotoDto> getPhotoDto() {
		return photoDto;
	}





	public void setPhotoDto(List<PhotoDto> photoDto) {
		this.photoDto = photoDto;
	}





	public RestaurantDetailDto(List<CuisineDto> cuisines, UserDto user, List<BenchDto> benches, List<ReviewDto> reviews,
			List<RecipeDto> recipeDto, List<PhotoDto> photoDto) {
		super();
		this.cuisines = cuisines;
		this.user = user;
		this.benches = benches;
		this.reviews = reviews;
		this.recipeDto = recipeDto;
		this.photoDto = photoDto;
	}





	public List<CuisineDto> getCuisines() {
		return cuisines;
	}

	public void setCuisines(List<CuisineDto> cuisines) {
		this.cuisines = cuisines;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public List<BenchDto> getBenches() {
		return benches;
	}

	public void setBenches(List<BenchDto> benches) {
		this.benches = benches;
	}

	public List<ReviewDto> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDto> reviews) {
		this.reviews = reviews;
	}

	public List<RecipeDto> getRecipeDto() {
		return recipeDto;
	}

	public void setRecipeDto(List<RecipeDto> recipeDto) {
		this.recipeDto = recipeDto;
	}
	
	
}
