package com.example.opentable.repository.dao.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.BookingDao;
import com.example.opentable.repository.dao.Utilities;
import com.example.opentable.repository.entity.Bench;
import com.example.opentable.repository.entity.Booking;
import com.example.opentable.repository.entity.TableOrder;
import com.example.opentable.repository.entity.User;
import com.example.opentable.transport.dto.BookingDto;
import com.example.opentable.transport.dto.CreateBookingDto;

@Repository
public class BookingDaoImpl extends AbstractParentDao<Booking> implements BookingDao{

	
	private List<BookingDto> convertBookingIntoDto(List<Booking> bookings)
	{
		List<BookingDto> bookingDtos = new ArrayList<>();
		try
		{
			if(bookings!=null && bookings.isEmpty()==false)
			{
				for(Booking booking:bookings)
				{
					BookingDto bookingDto = Utilities.convertBookingIntoDto(booking);
					bookingDtos.add(bookingDto);
				}
			}
		}
		
		catch(Exception e)
		{
			throw e;
		}
		return bookingDtos;
	}
	
	private LocalDateTime getDateTimeFromTimestamp(Long timestamp)
	{
		
		return	LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
	}
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<BookingDto> getAllBookingsByUser(int userId) {
		List<Booking> bookings =null;
		try
		{
			Query query = getEntityManager().createQuery("select b.booking from User b where b.userId=:id").setParameter("id",userId);
			bookings = query.getResultList();
			return convertBookingIntoDto(bookings);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}


	
	private void setTableOrder(CreateBookingDto createBookingDto,int i)
	{
		try
		{
			Bench bench = getEntityManager().getReference(Bench.class, createBookingDto.getBenchId());
			Booking booking = getEntityManager().getReference(Booking.class,i);
			TableOrder tableOrder = new TableOrder();
			tableOrder.setArrivalTime(getDateTimeFromTimestamp(createBookingDto.getArrivalTime()));
			tableOrder.setDepartTime(getDateTimeFromTimestamp(createBookingDto.getDepartureTime()));
			tableOrder.setBench(bench);
			tableOrder.setBooking(booking);
			getEntityManager().persist(tableOrder);
		}
		
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
	public int createBooking(CreateBookingDto createBookingDto) {
		int i;
		try
		{
		Booking booking = new Booking();
		User user =getEntityManager().getReference(User.class,createBookingDto.getUserId());
		booking.setPayment(createBookingDto.getPayment());
		booking.setPaymentId(createBookingDto.getPaymentId());
		booking.setUser(user);
		getEntityManager().persist(booking);
		i = booking.getBookingId();
		setTableOrder(createBookingDto,i);
		return booking.getBookingId();
		}
		
		catch(Exception e)
		{
		throw e;
		}
	}
	
	
	
	
	
	

}
