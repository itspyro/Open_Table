package com.example.opentable.repository.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public abstract class AbstractParentDao<T> {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	public void save(T t) {
		entityManager.persist(t);
	}
	
	public void delete(T t) {
		entityManager.remove(t);
	}
	
	public void update(T t) {
		entityManager.merge(t);
	}
}
