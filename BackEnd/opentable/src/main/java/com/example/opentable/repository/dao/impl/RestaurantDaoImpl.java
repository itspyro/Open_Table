package com.example.opentable.repository.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.RestaurantDao;
import com.example.opentable.repository.entity.Restaurant;

@Repository
public class RestaurantDaoImpl extends AbstractParentDao<Restaurant> implements RestaurantDao{

	@Override
	protected List<Restaurant> findAll() {
		String jpql = "SELECT c FROM Restaurant c";
        TypedQuery<Restaurant> query = entityManager.createQuery(jpql, Restaurant.class);
		return query.getResultList();
	}

}
