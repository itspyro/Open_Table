package com.example.opentable.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.entity.Bench;

@Repository
public class BenchRepository {
	@Autowired 
	private EntityManager entityManager;

	@Transactional
	public void save(Bench bench) {
		entityManager.persist(bench);
	}
	
	@Transactional 
	public void delete(Integer id) {
		Bench bench = entityManager.find(Bench.class, id);
		entityManager.remove(bench);
	}
	
	public List<Bench> findAllBenches(){
		String jpql = "select b from benches b";
		TypedQuery<Bench> query = entityManager.createQuery(jpql, Bench.class);
		return query.getResultList();
	}
	
	public List<Bench> findRestaurantBenches(Integer id){
		String jpql = "select b from benches b where restaurant_Id ="+ id;
		TypedQuery<Bench> query = entityManager.createQuery(jpql, Bench.class);
		return query.getResultList();
	}
	
}
