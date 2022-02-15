package com.example.opentable.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.example.opentable.repository.entity.Cuisine;

@Repository
public class CuisineRepository {
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public void save(Cuisine cuisine) {
		entityManager.persist(cuisine);
	}
	
	public List<Cuisine> findAllCuisines(){
		String jpql = "select c from cuisines c";
		TypedQuery<Cuisine> query = entityManager.createQuery(jpql, Cuisine.class);
		return query.getResultList();
	}
	
	public List<Cuisine> findRestaurantCuisine(Integer id){
		String jpql = "select c from cuisines c where restaurant_Id =" + id;
		TypedQuery<Cuisine> query = entityManager.createQuery(jpql, Cuisine.class);
		return query.getResultList();
	}
}
