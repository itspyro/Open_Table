package com.example.opentable.repository.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.ReviewDao;
import com.example.opentable.repository.entity.Review;

@Repository
public class ReviewDaoImpl extends AbstractParentDao<Review> implements ReviewDao {

	@Override
	protected List<Review> findAll() {
		String jpql = "SELECT r FROM Review r";
        TypedQuery<Review> query = entityManager.createQuery(jpql, Review.class);
		return query.getResultList();
	}

}
