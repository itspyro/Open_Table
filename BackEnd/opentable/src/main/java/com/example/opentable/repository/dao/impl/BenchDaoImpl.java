package com.example.opentable.repository.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.BenchDao;
import com.example.opentable.repository.entity.Bench;
import com.example.opentable.repository.entity.Restaurant;
import com.example.opentable.transport.dto.BenchDto;
import com.example.opentable.transport.dto.CreateBenchDto;

@Repository
public class BenchDaoImpl extends AbstractParentDao<Bench> implements BenchDao {

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int createBench(CreateBenchDto createBenchDto) throws Exception {
		int id;
		try {
			Bench bench = new Bench();
			bench.setBenchType(createBenchDto.getBenchType());
			bench.setCapacity(createBenchDto.getCapacity());
			
			Restaurant restaurant = getEntityManager().getReference(Restaurant.class, createBenchDto.getRestaurantId());
			bench.setRestaurant(restaurant);
			getEntityManager().persist(bench);
			
			id = bench.getBenchId();
			
			return id;
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
					BenchDto benchDto = new BenchDto();
					benchDto.setBenchId(bench.getBenchId());
					benchDto.setBenchType(bench.getBenchType());
					benchDto.setCapacity(bench.getCapacity());
					
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

}
