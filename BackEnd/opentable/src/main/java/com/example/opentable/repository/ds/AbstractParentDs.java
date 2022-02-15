package com.example.opentable.repository.ds;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.opentable.repository.entity.Role;

@Repository
@Transactional
public abstract class AbstractParentDs {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	public List<Role> findAll() {
        String jpql = "SELECT c FROM Role c";
        TypedQuery<Role> query = entityManager.createQuery(jpql, Role.class);
         
        return query.getResultList();
    }
}
