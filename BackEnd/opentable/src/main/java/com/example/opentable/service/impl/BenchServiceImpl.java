package com.example.opentable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.BenchDao;
import com.example.opentable.service.BenchService;
import com.example.opentable.transport.dto.BenchDto;
import com.example.opentable.transport.dto.CreateBenchDto;

@Service
public class BenchServiceImpl implements BenchService {
	
	@Autowired
	BenchDao benchDao;

	@Override
	public int createBench(CreateBenchDto createBenchDto) throws Exception {
		
		return benchDao.createBench(createBenchDto);
	}

	@Override
	public List<BenchDto> getRestaurantBenches(int restaurantId) throws Exception {
		
		return benchDao.getRestaurantBenches(restaurantId);
	}

	@Override
	public int deleteBench(int benchId) throws Exception {
		
		return benchDao.deleteBench(benchId);
	}
	
}
