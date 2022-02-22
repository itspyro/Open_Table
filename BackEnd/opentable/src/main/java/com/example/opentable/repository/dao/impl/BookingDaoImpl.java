package com.example.opentable.repository.dao.impl;

import org.springframework.stereotype.Repository;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.BookingDao;
import com.example.opentable.repository.entity.Booking;

@Repository
public class BookingDaoImpl extends AbstractParentDao<Booking> implements BookingDao{

}
