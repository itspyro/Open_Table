package com.example.opentable.repository.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.RestaurantDao;
import com.example.opentable.repository.dao.Utilities;
import com.example.opentable.repository.entity.Bench;
import com.example.opentable.repository.entity.Cuisine;
import com.example.opentable.repository.entity.Photo;
import com.example.opentable.repository.entity.Recipe;
import com.example.opentable.repository.entity.Restaurant;
import com.example.opentable.repository.entity.Review;
import com.example.opentable.repository.entity.User;
import com.example.opentable.transport.dto.BenchDto;
import com.example.opentable.transport.dto.CreateRestaurantDto;
import com.example.opentable.transport.dto.CuisineDto;
import com.example.opentable.transport.dto.CuisineListDto;
import com.example.opentable.transport.dto.FilterDto;
import com.example.opentable.transport.dto.PhotoDto;
import com.example.opentable.transport.dto.RecipeDto;
import com.example.opentable.transport.dto.RestaurantDetailDto;
import com.example.opentable.transport.dto.RestaurantDto;
import com.example.opentable.transport.dto.RestaurantUpdateDto;
import com.example.opentable.transport.dto.ReviewDto;

@Repository
public class RestaurantDaoImpl extends AbstractParentDao<Restaurant> implements RestaurantDao{

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<RestaurantDto> getRestaurants() throws Exception {
		List<Restaurant> restaurants = null;
		try {
			Query query = getEntityManager().createQuery("select r from Restaurant r");
			restaurants = (List<Restaurant>) query.getResultList();
			return convertRestaurantsIntoDto(restaurants);
			
		}
		catch(Exception e) {
			throw e;
		}
	}
	

	private List<RestaurantDto> convertRestaurantsIntoDto(List<Restaurant> restaurants) {
		List<RestaurantDto> restaurantDtos = new ArrayList<>();
		try {
			if(restaurants != null && restaurants.isEmpty()==false) {
				for(Restaurant restaurant:restaurants) {
					RestaurantDto restaurantDto = Utilities.convertRestaurantIntoDto(restaurant);
					
					List<CuisineDto> cuisines = new ArrayList<>();
					for (Cuisine cuisine : restaurant.getCuisines()) {
						CuisineDto cuisineDto = Utilities.convertCuisineIntoDto(cuisine);
						cuisines.add(cuisineDto);
					}
					restaurantDtos.add(restaurantDto);
				}
			}
		}
		catch(Exception e) {
			throw e;
		}
		
		return restaurantDtos;
	}
	
	private RestaurantDetailDto convertRestaurantDetailIntoDto(Restaurant restaurant) {
		RestaurantDetailDto restaurantDetail = new RestaurantDetailDto();
		try {
			if(restaurant!=null) {
				restaurantDetail.setAddress(Utilities.convertToAddressDto(restaurant.getAddress()));
				restaurantDetail.setClosingTime(restaurant.getClosingTime());
				restaurantDetail.setContact(restaurant.getContact());
				restaurantDetail.setDescription(restaurant.getDescription());
				restaurantDetail.setUser(Utilities.convertUserIntoDto(restaurant.getOwner()));
				restaurantDetail.setNonVeg(restaurant.isNonVeg());
				restaurantDetail.setOpeningTime(restaurant.getOpeningTime());
				restaurantDetail.setRestaurantName(restaurant.getRestaurantName());
				restaurantDetail.setRestaurantId(restaurant.getRestaurantId());
				restaurantDetail.setThumbnailPhoto(restaurant.getThumbnailPhoto());
				if(restaurant.getUsersRated()!=0) {
					restaurantDetail.setRating(restaurant.getRatingSum()/restaurant.getUsersRated());
				}
				List<CuisineDto> cuisineDtos = new ArrayList<>();
				for(Cuisine cuisine:restaurant.getCuisines()) {
					CuisineDto cuisineDto = Utilities.convertCuisineIntoDto(cuisine);
					cuisineDtos.add(cuisineDto);
				}
				List<BenchDto> benchDtos =new ArrayList<>();
				
				for(Bench bench:restaurant.getBenches()) {
					BenchDto benchDto = Utilities.convertBenchIntoDto(bench);
					benchDtos.add(benchDto);
				}
				
				List<ReviewDto> reviewDtos = new ArrayList<>();
				
				for(Review review : restaurant.getReviews()) {
					ReviewDto reviewDto = Utilities.convertReviewIntoDto(review);
					reviewDtos.add(reviewDto);
				}
				
				List<RecipeDto> recipeDtos = new ArrayList<> ();
				
				for(Recipe recipe:restaurant.getRecipes()) {
					RecipeDto recipeDto = Utilities.convertRecipeIntoDto(recipe);
					recipeDtos.add(recipeDto);
				}
				
				List<PhotoDto> photoDtos = new ArrayList<>();
				for(Photo photo:restaurant.getPhotos()) {
					PhotoDto photoDto = new PhotoDto();
					photoDto.setPhotoId(photo.getPhotoId());
					photoDto.setPhotoUrl(photo.getPhotoUrl());
					photoDtos.add(photoDto);
				}
				
				restaurantDetail.setBenches(benchDtos);
				restaurantDetail.setCuisines(cuisineDtos);
				restaurantDetail.setReviews(reviewDtos);
				restaurantDetail.setRecipeDto(recipeDtos);
				restaurantDetail.setPhotoDto(photoDtos);
			}
			return restaurantDetail;
		}
		catch(Exception e) {
			throw e;
		}
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int createRestaurant(CreateRestaurantDto restaurantDto) throws Exception {
		
		try {
			Restaurant restaurant = Utilities.convertDtoIntoRestaurant(restaurantDto);
			User user = getEntityManager().getReference(User.class, restaurantDto.getUserId());
			if(!user.getRole().getRoleName().equals("owner")){
				return -2;
			}
			restaurant.setOwner(user);
			
			List<Cuisine> cuisines = new ArrayList<>();
			if(restaurantDto.getCuisineIds()!=null) {
				for (CuisineDto cuisineDto : restaurantDto.getCuisineIds()) {
					Cuisine cuisine=null;
					if(cuisineDto.getCuisineId()!=0) {
						cuisine = getEntityManager().getReference(Cuisine.class, cuisineDto.getCuisineId());
					}
					else {
						cuisine = new Cuisine();
						cuisine.setCuisineName(cuisineDto.getCuisineName());
					}
					cuisines.add(cuisine);
				}
			}
			restaurant.setCuisines(cuisines);
			getEntityManager().persist(restaurant);
			return restaurant.getRestaurantId();
		}
		catch(Exception e) {
			System.out.print("ybyhb");
			throw e;
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int updateRestaurant(RestaurantUpdateDto restaurantDto) throws Exception {
		try {
			Restaurant restaurant = getEntityManager().getReference(Restaurant.class, restaurantDto.getRestaurantId());
			
			if(restaurant.getOwner().getUserId() != restaurantDto.getUserId()) {
				return -1;
			}
			
			restaurant = updateRestaurant(restaurantDto, restaurant);
			List<Cuisine> cuisines = new ArrayList<>();
			if(restaurantDto.getCuisineIds()!=null) {
				for (CuisineDto cuisineDto : restaurantDto.getCuisineIds()) {
					Cuisine cuisine=null;
					if(cuisineDto.getCuisineId()!=0) {
						cuisine = getEntityManager().getReference(Cuisine.class, cuisineDto.getCuisineId());
					}
					else {
						cuisine = new Cuisine();
						cuisine.setCuisineName(cuisineDto.getCuisineName());
					}
					cuisines.add(cuisine);
				}
			}
			restaurant.setCuisines(cuisines);
			getEntityManager().merge(restaurant);
			return restaurant.getRestaurantId();
		}
		catch(Exception e) {
			throw e;
		}
	}

	
	private Restaurant updateRestaurant(CreateRestaurantDto newRestaurant, Restaurant restaurant) {
		
		restaurant.setNonVeg(restaurant.isNonVeg());
		if(newRestaurant.getAddress()!=null) {
			restaurant.setAddress(Utilities.convertToAddress(newRestaurant.getAddress()));
		}
		if(newRestaurant.getClosingTime()!=null) {
			restaurant.setClosingTime(newRestaurant.getClosingTime());
		}
		if(newRestaurant.getOpeningTime()!=null) {
			restaurant.setOpeningTime(newRestaurant.getOpeningTime());
		}
		if(newRestaurant.getContact()!=null) {
			restaurant.setContact(newRestaurant.getContact());
		}
		if(newRestaurant.getDescription()!=null) {
			restaurant.setDescription(newRestaurant.getDescription());
		}
		if(newRestaurant.getGstIn()!=null) {
			restaurant.setGstIn(newRestaurant.getGstIn());
		}
		if(newRestaurant.getRestaurantName()!=null) {
			restaurant.setRestaurantName(newRestaurant.getRestaurantName());
		}
		if(newRestaurant.getThumbnailPhoto()!=null) {
			restaurant.getThumbnailPhoto();
		}
		return restaurant;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public RestaurantDetailDto getRestaurantById(int restaurantId) throws Exception {
		Restaurant restaurant = null;
		try {
			Query query = getEntityManager().createQuery("select r from Restaurant r where r.restaurantId = :id").setParameter("id",restaurantId);
			restaurant = (Restaurant) query.getSingleResult();
			return convertRestaurantDetailIntoDto(restaurant);
			
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int deleteRestaurant(int restaurantId) throws Exception {
		int noOfEntityDeleted=0;
		try {
			Query query = getEntityManager().createQuery("delete from Restaurant r where r.restaurantId = :id").setParameter("id",restaurantId);
			noOfEntityDeleted = query.executeUpdate();
			return noOfEntityDeleted;
		}
		catch(Exception e) {
			throw e;
		}
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<RestaurantDto> getRestaurantByUser(int userId) throws Exception {
		List<Restaurant> restaurants = null;
		try {
			Query query = getEntityManager().createQuery("select u.restaurants from User u "
					+ "where u.userId = :id").setParameter("id", userId);
			restaurants = (List<Restaurant>) query.getResultList();
			return convertRestaurantsIntoDto(restaurants);
		}
		catch(Exception e) {
			throw e;
		}
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<RestaurantDto> getRestaurantsByFilter(FilterDto filter) throws Exception{
		List<Restaurant> restaurants = null;
		List<Restaurant> restaurants2 = null;
		try {
			Query query;
			if(filter == null) {
				return getRestaurants();
			}
			if(filter.getCuisineIds()!=null){
				List<Integer> cuisinesId = filter.getCuisineIds();
				query = getEntityManager().createQuery("select distinct(c.restaurants)"
						+ " from Cuisine c where c.cuisineId in (:list)").setParameter("list", cuisinesId);
				restaurants = (List<Restaurant>) query.getResultList();
			}
			if(filter.getCity()!=null) {
				query = getEntityManager().createQuery("select distinct(r) from Restaurant r "
						+ "where r.address.city = :city").setParameter("city", filter.getCity());
				restaurants2 = (List<Restaurant>) query.getResultList();
				if(filter.getCuisineIds()!=null) {
					List<Restaurant> restaurants3 = new ArrayList<>();
					for(Restaurant restaurant :restaurants) {
						if(restaurants2.contains(restaurant)) {
							restaurants3.add(restaurant);
						}
					}
					restaurants2 = restaurants3;
				}
			}
			if(restaurants2!=null) {
				restaurants = restaurants2;
			}
			return convertRestaurantsIntoDto(restaurants);
			
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<String> getAllCity() throws Exception {
		List<String> cities = new ArrayList<>();
		try {
			Query query = getEntityManager().createQuery("select distinct(r.address.city) from Restaurant r");
			cities = query.getResultList();
			return cities;
		}
		catch(Exception e) {
			throw e;
		}
	}
}
