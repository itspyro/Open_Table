package com.example.opentable.repository.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.CuisineDao;
import com.example.opentable.repository.entity.Cuisine;
import com.example.opentable.transport.dto.CuisineDto;

@Repository
public class CuisineDaoImpl extends AbstractParentDao<Cuisine> implements CuisineDao {


	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<CuisineDto> getAllCuisines() {
		List<Cuisine> cuisines = null;
		try {
			Query query = getEntityManager().createQuery("Select c from Cuisine c");
			cuisines = query.getResultList();
			return convertCuisineIntoDto(cuisines);
		}
		catch(Exception e) {
			throw e;
		}
		
	}

	private List<CuisineDto> convertCuisineIntoDto(List<Cuisine> cuisines) {
		List<CuisineDto> cuisineDtos = new ArrayList<>();
		try {
			if(cuisines != null && cuisines.isEmpty()==false) {
				for(Cuisine cuisine:cuisines) {
					CuisineDto cuisineDto = new CuisineDto();
					cuisineDto.setCuisineId(cuisine.getCuisineId());
					cuisineDto.setCuisineName(cuisine.getCuisineName());
					cuisineDtos.add(cuisineDto);
				}
			}
		}
		catch(Exception e) {
			throw e;
		}
		return cuisineDtos;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<CuisineDto> getRestaurantCuisines(int restaurantId) {
		List<Cuisine> cuisines = null;
		try {
			Query query = getEntityManager().createQuery("Select d.cuisines from Restaurant d where d.restaurantId = :id").setParameter("id", restaurantId);
			cuisines = query.getResultList();
			return convertCuisineIntoDto(cuisines);
		}
		catch(Exception e) {
			throw e;
		}
	}

	
	@Override
	public int createCuisine(CuisineDto cuisineDto) {
		try {
			Cuisine cuisine = new Cuisine();
			cuisine.setCuisineName(cuisineDto.getCuisineName());
			getEntityManager().persist(cuisine);
			return cuisine.getCuisineId();
		}
		catch(Exception e) {
			throw e;
		}
	}

	
}
