package com.example.opentable.repository.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public abstract class AbstractParentDao<T> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	protected abstract List<T> findAll();
	
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
