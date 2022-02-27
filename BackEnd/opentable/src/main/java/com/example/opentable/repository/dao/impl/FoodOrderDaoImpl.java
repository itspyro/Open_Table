package com.example.opentable.repository.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.FoodOrderDao;
import com.example.opentable.repository.entity.Booking;
import com.example.opentable.repository.entity.FoodOrder;
import com.example.opentable.repository.entity.Recipe;
import com.example.opentable.transport.dto.FoodOrderDto;
import com.example.opentable.transport.dto.IntTrio;
import com.example.opentable.transport.dto.Intpair;
import com.example.opentable.transport.dto.ReturnFoodOrderDto;



@Repository
public class FoodOrderDaoImpl extends AbstractParentDao<FoodOrder> implements FoodOrderDao
{

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Integer> createFoodOrder(FoodOrderDto foodOrderDto) 
	{
		try
		{
			List<Integer> foodOrderIdList = new ArrayList<>();
			for(Intpair pair:foodOrderDto.getRecipies())
			{
				FoodOrder foodOrder = new FoodOrder();
				Booking booking = getEntityManager().getReference(Booking.class, foodOrderDto.getBookingId());
				Recipe recipe = getEntityManager().getReference(Recipe.class, pair.getRecipeId());
				int quantity = pair.getQuantity();
				foodOrder.setBooking(booking);
				foodOrder.setRecipe(recipe);
				foodOrder.setQuantity(quantity);
				foodOrder.setPrice(recipe.getPrice());
				getEntityManager().persist(foodOrder);
				foodOrderIdList.add(foodOrder.getFoodOrderId());
			}
			return foodOrderIdList;
		}
		
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	private ReturnFoodOrderDto convertFoodOrderIntoReturnFoodOrderDto(List<FoodOrder> foodOrders)
	{
		List<IntTrio> intTrio = new ArrayList<>();
		ReturnFoodOrderDto returnFoodOrderDto = new ReturnFoodOrderDto();
		try
		{
			if(foodOrders!=null && foodOrders.isEmpty()==false)
			for(FoodOrder foodOrder:foodOrders)
			{
				IntTrio setDetails = new IntTrio();
				setDetails.setRecipeId(foodOrder.getRecipe().getRecipeId());
				setDetails.setQuantity(foodOrder.getQuantity());
				setDetails.setPrice(foodOrder.getPrice());
				intTrio.add(setDetails);
			}
			returnFoodOrderDto.setRecipies(intTrio);
		}
		
		catch(Exception e)
		{
			throw e;
		}
		
		return returnFoodOrderDto;
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
	public ReturnFoodOrderDto getFoodOrderByBooking(int bookingId)  
	{
		List<FoodOrder> foodOrders= new ArrayList<>();
		try
		{
			Query query = getEntityManager().createQuery("select b from FoodOrder b where b.booking.BookingId = :id").setParameter("id", bookingId);
			foodOrders = query.getResultList();
			return convertFoodOrderIntoReturnFoodOrderDto(foodOrders);
		}
		
		catch (Exception e)
		{
			throw e;
		}
	}

}
