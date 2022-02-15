package com.example.opentable.repository.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.PhotoDao;
import com.example.opentable.repository.entity.Photo;

@Repository
public class PhotoDaoImpl extends AbstractParentDao<Photo> implements PhotoDao{

	@Override
	protected List<Photo> findAll() {
		String jpql = "SELECT c FROM photos c";
        TypedQuery<Photo> query = entityManager.createQuery(jpql, Photo.class);
		return query.getResultList();
	}

}
