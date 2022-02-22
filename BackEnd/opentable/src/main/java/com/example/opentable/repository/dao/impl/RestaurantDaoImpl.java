package com.example.opentable.repository.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.RestaurantDao;
import com.example.opentable.repository.dao.Utilities;
import com.example.opentable.repository.entity.Address;
import com.example.opentable.repository.entity.Cuisine;
import com.example.opentable.repository.entity.Restaurant;
import com.example.opentable.repository.entity.User;
import com.example.opentable.transport.dto.AddressDto;
import com.example.opentable.transport.dto.CuisineDto;
import com.example.opentable.transport.dto.CuisineListDto;
import com.example.opentable.transport.dto.RestaurantDto;
import com.example.opentable.transport.dto.UserDto;

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
					
					restaurantDto.setCuisines(cuisines);
					UserDto user = Utilities.convertUserIntoDto(restaurant.getOwner());
					restaurantDto.setUser(user);
					restaurantDtos.add(restaurantDto);
				}
			}
		}
		catch(Exception e) {
			throw e;
		}
		
		return restaurantDtos;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int createRestaurant(RestaurantDto restaurantDto) throws Exception {
		
		try {
			Restaurant restaurant = Utilities.convertDtoIntoRestaurant(restaurantDto);
			User user = getEntityManager().getReference(User.class, restaurantDto.getUser().getUserId());
			restaurant.setOwner(user);
			
			List<Cuisine> cuisines = new ArrayList<>();
			for (CuisineDto cuisineDto : restaurantDto.getCuisines()) {
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
	public List<RestaurantDto> getRestaurantById(int restaurantId) throws Exception {
		List<Restaurant> restaurants = null;
		try {
			Query query = getEntityManager().createQuery("select r from Restaurant r where r.restaurantId = :id").setParameter("id",restaurantId);
			restaurants = (List<Restaurant>) query.getResultList();
			return convertRestaurantsIntoDto(restaurants);
			
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int deleteRestaurant(int restaurantId) throws Exception {
		return 0;
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
	public List<RestaurantDto> getRestaurantsByCuisine(CuisineListDto cuisineIds) {
		List<Restaurant> restaurants = null;
		try {
			List<Integer> cuisinesId = cuisineIds.getCuisineIds();
			Query query = getEntityManager().createQuery("select distinct(c.restaurants) from Cuisine c where c.cuisineId in (:list)").setParameter("list", cuisinesId);
			restaurants = (List<Restaurant>) query.getResultList();
			return convertRestaurantsIntoDto(restaurants);
			
		}
		catch(Exception e) {
			throw e;
		}
	}

}
