package com.example.opentable.repository.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.BenchDao;
import com.example.opentable.repository.entity.Bench;

@Repository
public class BenchDaoImpl extends AbstractParentDao<Bench> implements BenchDao {
	
	

	@Override
	protected List<Bench> findAll() {
		String jpql = "SELECT b FROM benches b";
        TypedQuery<Bench> query = entityManager.createQuery(jpql, Bench.class);
		return query.getResultList();
	}

}
