package com.example.opentable.service;

import java.util.List;

import com.example.opentable.transport.dto.BenchDto;
import com.example.opentable.transport.dto.CreateBenchDto;

public interface BenchService {
	
	int createBench(CreateBenchDto createBenchDto) throws Exception;

	List<BenchDto> getRestaurantBenches(int restaurantId) throws Exception;

	int deleteBench(int benchId) throws Exception;
}
