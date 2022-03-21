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
import com.example.opentable.repository.dao.TableOrderDao;
import com.example.opentable.repository.dao.Utilities;
import com.example.opentable.repository.entity.Bench;
import com.example.opentable.repository.entity.Restaurant;
import com.example.opentable.repository.entity.TableOrder;
import com.example.opentable.transport.dto.BenchDto;
import com.example.opentable.transport.dto.CheckAvailabilityDto;

@Repository
public class TableOrderDaoImpl extends AbstractParentDao<TableOrder> implements TableOrderDao{

	private List<BenchDto> convertBenchesIntoDto(List<Bench> benches)
	{
		List<BenchDto> benchDtos = new ArrayList<>();
		try
		{
			if(benches!=null && benches.isEmpty()==false)
			{
				for(Bench bench:benches)
				{
					BenchDto benchDto = Utilities.convertBenchIntoDto(bench);
					benchDtos.add(benchDto);
				}
			}
		}
		
		catch (Exception e)
		{
			throw e;
		}
		
		return benchDtos;
	}
	
	private LocalDateTime getDateTimeFromTimestamp(Long timestamp)
	{
		
		return	LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<BenchDto> checkAvailability(CheckAvailabilityDto checkAvailabilityDto) {
		List<Bench> benches = null;
		List<Bench> benches1 = null;

		Restaurant restaurant = getEntityManager().getReference(Restaurant.class, checkAvailabilityDto.getRestaurantId());
		try
		{
			benches = restaurant.getBenches();
			List<Integer> benchIds = new ArrayList<>();
			for(Bench bench:benches)
			{
				benchIds.add(bench.getBenchId());
				System.out.print(bench.getBenchId());
			}
			
			
			
			Query query =getEntityManager().createQuery("select t.bench from TableOrder t where t.bench.benchId in (:list)"
				+" and t.arrivalTime >= :arrive and t.departureTime <= :depart and t.bench.benchType = :type and t.bench.capacity >= :capacity"
				).setParameter("list", benchIds).setParameter("arrive",getDateTimeFromTimestamp(checkAvailabilityDto.getArrivalTime())).setParameter("depart",getDateTimeFromTimestamp(checkAvailabilityDto.getDepartureTime())).setParameter("type", checkAvailabilityDto.getBenchType()).setParameter("capacity", checkAvailabilityDto.getNoOfPersons());
			benches1 =(List<Bench>)query.getResultList();

			Query query1 =getEntityManager().createQuery("Select t from Bench t where t.capacity >= :capacity").setParameter("capacity",checkAvailabilityDto.getNoOfPersons());
			List<Bench> benches3=query1.getResultList();



			for(Bench bench:benches1)
			{
				if(benches3.contains(bench))
					benches3.remove(bench);

			}

			return convertBenchesIntoDto(benches3);
		}
		
		catch(Exception e)
		{
			throw e;
		}
		
		
	}


		
	

}
