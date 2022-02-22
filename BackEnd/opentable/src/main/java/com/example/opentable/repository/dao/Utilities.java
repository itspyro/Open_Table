package com.example.opentable.repository.dao;

import java.util.Date;

import com.example.opentable.repository.entity.Address;
import com.example.opentable.repository.entity.Bench;
import com.example.opentable.repository.entity.Cuisine;
import com.example.opentable.repository.entity.Recipe;
import com.example.opentable.repository.entity.Restaurant;
import com.example.opentable.repository.entity.Review;
import com.example.opentable.repository.entity.User;
import com.example.opentable.transport.dto.AddressDto;
import com.example.opentable.transport.dto.BenchDto;
import com.example.opentable.transport.dto.CreateBenchDto;
import com.example.opentable.transport.dto.CreateRecipeDto;
import com.example.opentable.transport.dto.CreateReviewDto;
import com.example.opentable.transport.dto.CreateUserDto;
import com.example.opentable.transport.dto.CuisineDto;
import com.example.opentable.transport.dto.RecipeDto;
import com.example.opentable.transport.dto.RestaurantDto;
import com.example.opentable.transport.dto.ReviewDetailDto;
import com.example.opentable.transport.dto.UserDto;

public class Utilities {
	public static RestaurantDto convertRestaurantIntoDto(Restaurant restaurant) {
		RestaurantDto restaurantDto = new RestaurantDto();
		restaurantDto.setRestaurantId(restaurant.getRestaurantId());
		restaurantDto.setRestaurantName(restaurant.getRestaurantName());
		restaurantDto.setAddress(convertToAddressDto(restaurant.getAddress()));
		restaurantDto.setContact(restaurant.getContact());
		restaurantDto.setDescription(restaurant.getDescription());
		restaurantDto.setGstIn(restaurant.getGstIn());
		restaurantDto.setNonVeg(restaurant.isNonVeg());
		restaurantDto.setClosingTime(restaurant.getClosingTime());
		restaurantDto.setOpeningTime(restaurant.getOpeningTime());
		if(restaurant.getUsersRated()!=0) {
			restaurantDto.setRating(restaurant.getRatingSum()/restaurant.getUsersRated());
		}
		return restaurantDto;
	}
	
	
	public static Restaurant convertDtoIntoRestaurant(RestaurantDto restaurantDto) {
		Restaurant restaurant = new Restaurant();
		restaurant.setRestaurantName(restaurantDto.getRestaurantName());
		restaurant.setAddress(convertToAddress(restaurantDto.getAddress()));
		restaurant.setGstIn(restaurantDto.getGstIn());
		restaurant.setContact(restaurantDto.getContact());
		restaurant.setDescription(restaurantDto.getDescription());
		restaurant.setNonVeg(restaurantDto.isNonVeg());
		restaurant.setOpeningTime(restaurantDto.getOpeningTime());
		restaurant.setClosingTime(restaurantDto.getClosingTime());
		return restaurant;
	}
	
//***************************************************************************************************************************************	
	
	private static AddressDto convertToAddressDto(Address address) {
		AddressDto addressDto = new AddressDto();
		addressDto.setAddressLine1(address.getAddressLine1());
		addressDto.setAddressLine2(address.getAddressLine2());
		addressDto.setCity(address.getCity());
		addressDto.setPincode(address.getPincode());
		return addressDto;
	}


	private static Address convertToAddress(AddressDto addressDto) {
		Address address = new Address();
		address.setAddressLine1(addressDto.getAddressLine1());
		address.setAddressLine2(addressDto.getAddressLine2());
		address.setCity(addressDto.getCity());
		address.setPincode(addressDto.getPincode());
		return address;
	}
	
//***************************************************************************************************************************************	

	
	public static User convertDtoIntoUser(CreateUserDto userDto) {
		User user = new User();
		user.setUserName(userDto.getUserName());
		user.setUserFirstName(userDto.getUserFirstName());
		user.setUserLastName(userDto.getUserLastName());
		user.setUserEmail(userDto.getUserEmail());
		user.setPassword(userDto.getPassword());
		user.setUserPhoneNumber(userDto.getUserPhoneNumber());
		user.setUserAddress(userDto.getUserAddress());
		return user;
	}
	
	
	public static UserDto convertUserIntoDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUserId(user.getUserId());
		userDto.setUserName(user.getUserName());
		userDto.setUserFirstName(user.getUserFirstName());
		userDto.setUserLastName(user.getUserLastName());
		userDto.setUserEmail(user.getUserEmail());
		userDto.setPassword(user.getPassword());
		userDto.setUserPhoneNumber(user.getUserPhoneNumber());
		userDto.setUserAddress(user.getUserAddress());
		return userDto;
	}
	
	
//***************************************************************************************************************************************
	
	
	public static CuisineDto convertCuisineIntoDto(Cuisine cuisine) {
		CuisineDto cuisineDto = new CuisineDto();
		cuisineDto.setCuisineId(cuisine.getCuisineId());
		cuisineDto.setCuisineName(cuisine.getCuisineName());
		return cuisineDto;
	}
	
//***************************************************************************************************************************************

	public static RecipeDto convertRecipeIntoDto(Recipe recipe) {
		RecipeDto recipeDto = new RecipeDto();
		recipeDto.setRecipeId(recipe.getRecipeId());
		recipeDto.setRecipeName(recipe.getRecipeName());
		recipeDto.setPrice(recipe.getPrice());
		return recipeDto;
	}
	
	public static Recipe convertDtoIntoRecipe(CreateRecipeDto recipeDto) {
		Recipe recipe = new Recipe();
		recipe.setRecipeName(recipeDto.getRecipeName());
		recipe.setPrice(recipeDto.getPrice());
		return recipe;
	}
	
//***************************************************************************************************************************************
	
	public static Bench convertDtoIntoBench(CreateBenchDto createBenchDto) {
		Bench bench = new Bench();
		bench.setBenchType(createBenchDto.getBenchType());
		bench.setCapacity(createBenchDto.getCapacity());
		return bench;
	}
	
	public static BenchDto convertBenchIntoDto(Bench bench) {
		BenchDto benchDto = new BenchDto();
		benchDto.setBenchId(bench.getBenchId());
		benchDto.setBenchType(bench.getBenchType());
		benchDto.setCapacity(bench.getCapacity());
		return benchDto;
	}
	
//***************************************************************************************************************************************	
	public static Review convertDtoIntoReview(CreateReviewDto createReview) {
		Review review = new Review();
		review.setRating(createReview.getRating());
		review.setReview(createReview.getReview());
		review.setTimestamp(new Date());
		return review;
	}
	
	public static ReviewDetailDto convertReviewIntoDto(Review review) {
		ReviewDetailDto reviewDto= new ReviewDetailDto();
		reviewDto.setRating(review.getRating());
		reviewDto.setReview(review.getReview());
		reviewDto.setReviewId(review.getReviewId());
		reviewDto.setTimestamp(review.getTimestamp());
		return reviewDto;
	}
	
//***************************************************************************************************************************************
}
