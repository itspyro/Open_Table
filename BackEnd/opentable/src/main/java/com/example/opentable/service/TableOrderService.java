package com.example.opentable.service;

import java.util.List;


import com.example.opentable.transport.dto.BenchDto;
import com.example.opentable.transport.dto.CheckAvailabilityDto;


public interface TableOrderService {
 
	public List<BenchDto> checkavailability(CheckAvailabilityDto checkavailabilityDto) throws Exception;
}
