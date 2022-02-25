package com.example.opentable.repository.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.BenchDao;
import com.example.opentable.repository.dao.Utilities;
import com.example.opentable.repository.entity.Bench;
import com.example.opentable.repository.entity.Restaurant;
import com.example.opentable.transport.dto.BenchDto;
import com.example.opentable.transport.dto.CreateBenchDto;

@Repository
public class BenchDaoImpl extends AbstractParentDao<Bench> implements BenchDao {

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String createBench(CreateBenchDto createBenchDto) throws Exception {
		String s="";
		try {
			Restaurant restaurant = getEntityManager().getReference(Restaurant.class, createBenchDto.getRestaurantId());
			for(int i=0;i<createBenchDto.getNoOfBench();i++) {
				Bench bench = Utilities.convertDtoIntoBench(createBenchDto);
				bench.setRestaurant(restaurant);
				getEntityManager().persist(bench);
				s += bench.getBenchId()+", ";
			}
			
			return s;
		} 
		catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<BenchDto> getRestaurantBenches(int restaurantId) throws Exception {
		List<Bench> benches = null;
		try {
			Query query = getEntityManager().createQuery("Select r.benches from Restaurant r where r.restaurantId = :id").setParameter("id", restaurantId);
			benches = query.getResultList();
			return convertBenchIntoDto(benches);
		}
		catch(Exception e) {
			throw e;
		}
	}

	private List<BenchDto> convertBenchIntoDto(List<Bench> benches) {
		List<BenchDto> benchDtos = new ArrayList<>();
		try {
			if(benches != null && benches.isEmpty()==false) {
				for (Bench bench : benches) {
					BenchDto benchDto = Utilities.convertBenchIntoDto(bench);
					benchDtos.add(benchDto);
				}
			}
		}
		catch(Exception e) {
			throw e;
		}
		return benchDtos;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteBench(int benchId) throws Exception {
		int numberOfEntityDeleted = 0;
		try {
	        Query query = getEntityManager().createQuery("delete from Bench b where b.benchId = :id").setParameter("id",benchId);
	        numberOfEntityDeleted = query.executeUpdate();
			return numberOfEntityDeleted;
		}
		catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public int updateBench(CreateBenchDto benchDto) throws Exception {
		try {
			Bench bench = getEntityManager().getReference(Bench.class, benchDto.getBenchId());
			bench = updateBench(benchDto, bench);
			getEntityManager().merge(bench);
			return bench.getBenchId();
		}
		catch(Exception e) {
			throw e;
		}
	}

	private Bench updateBench(CreateBenchDto benchDto, Bench bench) {
		try {
			if(benchDto.getBenchType()!=null) {
				bench.setBenchType(benchDto.getBenchType());
			}
			if(benchDto.getCapacity()!=0) {
				bench.setCapacity(benchDto.getCapacity());
			}
			if(benchDto.getPrice()!=0) {
				bench.setPrice(benchDto.getPrice());
			}
			return bench;
		}
		catch(Exception e) {
			throw e;
		}	
	}

}
