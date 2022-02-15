package com.example.opentable.repository.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.CuisineDao;
import com.example.opentable.repository.entity.Cuisine;

@Repository
public class CuisineDaoImpl extends AbstractParentDao<Cuisine> implements CuisineDao {

	@Override
	protected List<Cuisine> findAll() {
		String jpql = "SELECT c FROM cuisines c";
        TypedQuery<Cuisine> query = entityManager.createQuery(jpql, Cuisine.class);
		return query.getResultList();
	}
	
}
