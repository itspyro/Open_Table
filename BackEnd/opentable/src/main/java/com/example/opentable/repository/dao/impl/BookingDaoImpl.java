package com.example.opentable.repository.dao.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.BookingDao;
import com.example.opentable.repository.dao.Utilities;
import com.example.opentable.repository.entity.Address;
import com.example.opentable.repository.entity.Bench;
import com.example.opentable.repository.entity.Booking;
import com.example.opentable.repository.entity.FoodOrder;
import com.example.opentable.repository.entity.Restaurant;
import com.example.opentable.repository.entity.Role;
import com.example.opentable.repository.entity.TableOrder;
import com.example.opentable.repository.entity.User;
import com.example.opentable.transport.dto.AddressDto;
import com.example.opentable.transport.dto.BookingDto;
import com.example.opentable.transport.dto.BookingFoodOrderDetailsDto;
import com.example.opentable.transport.dto.BookingRecipeDetailsDto;
import com.example.opentable.transport.dto.BookingRestaurantDetailsDto;
import com.example.opentable.transport.dto.BookingTableOrderDetailsDto;
import com.example.opentable.transport.dto.BookingUserDetailsDto;
import com.example.opentable.transport.dto.CreateBookingDto;
import com.example.opentable.transport.dto.PaymentUpdateDto;
import com.example.opentable.transport.dto.RestaurantBookingsDto;
import com.example.opentable.transport.dto.UserBookingsDto;

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
	public List<UserBookingsDto> getAllBookingsByUser(int userId) {
		
		List<UserBookingsDto> userBookingsDto = new ArrayList<>() ;
		try
		{
			Query query = getEntityManager().createQuery("select b.booking from User b where b.userId=:id").setParameter("id",userId);
			
			List<Booking> bookings = query.getResultList();
			
			System.out.println(bookings);
			
			for (Booking booking : bookings) {
				
				UserBookingsDto userBookingDto = new UserBookingsDto();
				
				userBookingDto.setBookingId(booking.getBookingId());
				
				Query query2 = getEntityManager().createQuery("select b from FoodOrder b where b.booking.BookingId in :id").setParameter("id", booking.getBookingId());
				List<FoodOrder> foodOrders = query2.getResultList();
				
				List<BookingFoodOrderDetailsDto> foodOrderDtos = new ArrayList<>();
				
				for (FoodOrder foodOrder : foodOrders) {
					
					BookingFoodOrderDetailsDto foodOrderDto = new BookingFoodOrderDetailsDto();
					
					foodOrderDto.setFoodOrderId(foodOrder.getFoodOrderId());
					foodOrderDto.setPrice(foodOrder.getPrice());
					foodOrderDto.setQuantity(foodOrder.getQuantity());
					
					BookingRecipeDetailsDto recipeDto = new BookingRecipeDetailsDto();
					
					recipeDto.setRecipeId(foodOrder.getRecipe().getRecipeId());
					recipeDto.setRecipeName(foodOrder.getRecipe().getRecipeName());
					recipeDto.setPrice(foodOrder.getRecipe().getPrice());
					
					foodOrderDto.setRecipe(recipeDto);
					
					foodOrderDtos.add(foodOrderDto);
				}
				
				userBookingDto.setFoodOrder(foodOrderDtos);
				
				Query query3 = getEntityManager().createQuery("select b from TableOrder b where b.booking.BookingId in :id").setParameter("id", booking.getBookingId());
				TableOrder tableOrder = (TableOrder) query3.getSingleResult();
				
				BookingTableOrderDetailsDto tableOrderDto = new BookingTableOrderDetailsDto();
				
				tableOrderDto.setTableOrderId(tableOrder.getTableOrderId());
				
				DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy"); 
				DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm a"); 
				
				tableOrderDto.setArrivalTime(tableOrder.getArrivalTime().format(timeFormatter));
				tableOrderDto.setDate(tableOrder.getArrivalTime().format(dateFormatter));
				
				tableOrderDto.setPersons(tableOrder.getBench().getCapacity());
				
				userBookingDto.setTableOrder(tableOrderDto);
				
				Query query4 = getEntityManager().createQuery("select b from Restaurant b where b.restaurantId in :id").setParameter("id", tableOrder.getBench().getRestaurant().getRestaurantId());
				Restaurant restaurant = (Restaurant) query4.getSingleResult();
				
				BookingRestaurantDetailsDto restaurantDto = new BookingRestaurantDetailsDto();
				
				restaurantDto.setRestaurantId(restaurant.getRestaurantId());
				restaurantDto.setRestaurantName(restaurant.getRestaurantName());
				
				Address address = restaurant.getAddress();
				
				AddressDto addressDto = new AddressDto();
				addressDto.setAddressLine1(address.getAddressLine1());
				addressDto.setAddressLine2(address.getAddressLine2());
				addressDto.setCity(address.getCity());
				addressDto.setPincode(address.getPincode());
				
				restaurantDto.setAddress(addressDto);
				restaurantDto.setThumbnailPhoto(restaurant.getThumbnailPhoto());
				
				userBookingDto.setRestaurant(restaurantDto);
				
				userBookingsDto.add(userBookingDto);
			}
			
			return userBookingsDto;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}


	
	private void setTableOrder(CreateBookingDto createBookingDto,Booking booking)
	{
		try
		{
			Bench bench = getEntityManager().getReference(Bench.class, createBookingDto.getBenchId());
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
			System.out.println(createBookingDto.getUserId());
			User user =getEntityManager().getReference(User.class,createBookingDto.getUserId());
			booking.setPayment(createBookingDto.getPayment());
			booking.setOrderId(createBookingDto.getOrderId());
			booking.setStatus(createBookingDto.getStatus());
			booking.setPaymentId(createBookingDto.getPaymentId());
			booking.setUser(user);
			getEntityManager().persist(booking);
			setTableOrder(createBookingDto,booking);
			return booking.getBookingId();
		}
		
		catch(Exception e)
		{
		throw e;
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<RestaurantBookingsDto> getAllBookingsByRestaurant(int restaurantId, int userId) throws Exception {
		List<RestaurantBookingsDto> restaurantBookingsDto = new ArrayList<>();
		try
		{
			Query query2 = getEntityManager().createQuery("select u.role from User u where u.userId = :id").setParameter("id",userId);
			Role role = (Role) query2.getSingleResult();
			
			if(role.getRoleName().equals("owner")) {
				
				Query query = getEntityManager().createQuery("select t.benchId from Bench t where t.restaurant.restaurantId = :id").setParameter("id",restaurantId);
				List<Integer> benchIds = query.getResultList();
				
				Query query3 = getEntityManager().createQuery("select t from TableOrder t where t.bench.benchId in :id").setParameter("id",benchIds);
				List<TableOrder> tableOrders = query3.getResultList();
				
				for (TableOrder tableOrder : tableOrders) {
					
					RestaurantBookingsDto restaurantBookingDto = new RestaurantBookingsDto();
				
					BookingTableOrderDetailsDto tableOrderDto = new BookingTableOrderDetailsDto();
					
					tableOrderDto.setTableOrderId(tableOrder.getTableOrderId());
					
					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy"); 
					DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm a"); 
					
					tableOrderDto.setArrivalTime(tableOrder.getArrivalTime().format(timeFormatter));
					tableOrderDto.setDate(tableOrder.getArrivalTime().format(dateFormatter));
					
					tableOrderDto.setPersons(tableOrder.getBench().getCapacity());
					
					restaurantBookingDto.setTableOrder(tableOrderDto);
					
					restaurantBookingDto.setBookingId(tableOrder.getBooking().getBookingId());
					
					Query query4 = getEntityManager().createQuery("select b.user from Booking b where b.BookingId=:id").setParameter("id",tableOrder.getBooking().getBookingId());
					
					User user = (User) query4.getSingleResult();
					
					BookingUserDetailsDto userDto = new BookingUserDetailsDto();
					
					userDto.setUserId(user.getUserId());
					userDto.setUserName(user.getUserName());
					userDto.setUserEmail(user.getUserEmail());
					userDto.setProfilePhoto(user.getProfilePhoto());
					
					restaurantBookingDto.setUser(userDto);
					
					Query query5 = getEntityManager().createQuery("select b from FoodOrder b where b.booking.BookingId in :id").setParameter("id", tableOrder.getBooking().getBookingId());
					List<FoodOrder> foodOrders = query5.getResultList();
					
					List<BookingFoodOrderDetailsDto> foodOrderDtos = new ArrayList<>();
					
					for (FoodOrder foodOrder : foodOrders) {
						
						BookingFoodOrderDetailsDto foodOrderDto = new BookingFoodOrderDetailsDto();
						
						foodOrderDto.setFoodOrderId(foodOrder.getFoodOrderId());
						foodOrderDto.setPrice(foodOrder.getPrice());
						foodOrderDto.setQuantity(foodOrder.getQuantity());
						
						BookingRecipeDetailsDto recipeDto = new BookingRecipeDetailsDto();
						
						recipeDto.setRecipeId(foodOrder.getRecipe().getRecipeId());
						recipeDto.setRecipeName(foodOrder.getRecipe().getRecipeName());
						recipeDto.setPrice(foodOrder.getRecipe().getPrice());
						
						foodOrderDto.setRecipe(recipeDto);
						
						foodOrderDtos.add(foodOrderDto);
					}
					
					restaurantBookingDto.setFoodOrder(foodOrderDtos);
					
					restaurantBookingsDto.add(restaurantBookingDto);
				}
				
			}
			return restaurantBookingsDto;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void create(Booking booking) {
		save(booking);
		
	}

	@Override
	public void updatePayment(PaymentUpdateDto data) {
		Query query = getEntityManager().createQuery("select b from Booking b where b.orderId = :id").setParameter("id", data.getOrderId());
		 Booking booking = (Booking) query.getSingleResult();
		 booking.setPaymentId(data.getPaymentId());
		 booking.setStatus(data.getStatus());
		 update(booking);
		
	}
	
	
	
	
	
	

}
