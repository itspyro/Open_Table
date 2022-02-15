package com.example.opentable.repository.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.RecipeDao;
import com.example.opentable.repository.entity.Recipe;

@Repository
public class RecipeDaoImpl extends AbstractParentDao<Recipe> implements RecipeDao{

	@Override
	protected List<Recipe> findAll() {
		String jpql = "SELECT r FROM recipes r";
        TypedQuery<Recipe> query = entityManager.createQuery(jpql, Recipe.class);
		return query.getResultList();
	}

}
