package com.example.opentable.repository.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.BenchDao;
import com.example.opentable.repository.entity.Bench;

@Repository
public class BenchDaoImpl extends AbstractParentDao<Bench> implements BenchDao {
	
	
	
	public List<Bench> findBenchesByRestaurant(){
		return null;
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
