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
					
					List<CuisineDto> cuisines = new ArrayList<>();
					for (Cuisine cuisine : restaurant.getCuisines()) {
						CuisineDto cuisineDto = new CuisineDto();
						cuisineDto.setCuisineId(cuisine.getCuisineId());
						cuisineDto.setCuisineName(cuisine.getCuisineName());
						cuisines.add(cuisineDto);
					}
					
					restaurantDto.setCuisines(cuisines);
					UserDto user = new UserDto();
					user.setUserEmail(restaurant.getOwner().getUserEmail());
					user.setPassword(restaurant.getOwner().getPassword());
					user.setUserAddress(restaurant.getOwner().getUserAddress());
					user.setUserId(restaurant.getOwner().getUserId());
					user.setUserPhoneNumber(restaurant.getOwner().getUserPhoneNumber());
					user.setUserName(restaurant.getOwner().getUserName());
					user.setUserFirstName(restaurant.getOwner().getUserFirstName());
					user.setUserLastName(restaurant.getOwner().getUserLastName());
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

	private AddressDto convertToAddressDto(Address address) {
		AddressDto addressDto = new AddressDto();
		addressDto.setAddressLine1(address.getAddressLine1());
		addressDto.setAddressLine2(address.getAddressLine2());
		addressDto.setCity(address.getCity());
		addressDto.setPincode(address.getPincode());
		return addressDto;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int createRestaurant(RestaurantDto restaurantDto) throws Exception {
		
		try {
			Restaurant restaurant = new Restaurant();
			restaurant.setRestaurantName(restaurantDto.getRestaurantName());
			restaurant.setAddress(convertToAddress(restaurantDto.getAddress()));
			restaurant.setGstIn(restaurantDto.getGstIn());
			restaurant.setContact(restaurantDto.getContact());
			restaurant.setDescription(restaurantDto.getDescription());
			restaurant.setNonVeg(restaurantDto.isNonVeg());
			restaurant.setOpeningTime(restaurantDto.getOpeningTime());
			restaurant.setClosingTime(restaurantDto.getClosingTime());
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

	private Address convertToAddress(AddressDto addressDto) {
		Address address = new Address();
		address.setAddressLine1(addressDto.getAddressLine1());
		address.setAddressLine2(addressDto.getAddressLine2());
		address.setCity(addressDto.getCity());
		address.setPincode(addressDto.getPincode());
		return address;
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
