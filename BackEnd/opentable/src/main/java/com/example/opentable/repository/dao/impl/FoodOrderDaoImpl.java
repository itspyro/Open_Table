package com.example.opentable.repository.dao.impl;

import org.springframework.stereotype.Repository;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.FoodOrderDao;
import com.example.opentable.repository.entity.FoodOrder;

@Repository
public class FoodOrderDaoImpl extends AbstractParentDao<FoodOrder> implements FoodOrderDao{

}
