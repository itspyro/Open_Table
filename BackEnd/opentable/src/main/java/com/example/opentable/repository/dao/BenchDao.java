package com.example.opentable.repository.dao;

import java.util.List;

import com.example.opentable.transport.dto.BenchDto;
import com.example.opentable.transport.dto.CreateBenchDto;

public interface BenchDao {

	String createBench(CreateBenchDto createBenchDto) throws Exception;

	List<BenchDto> getRestaurantBenches(int restaurantId) throws Exception;

	int deleteBench(int benchId) throws Exception;
	
	int updateBench(CreateBenchDto benchDto) throws Exception;
	

}
