package com.example.opentable.repository.dao;

import java.util.List;


import com.example.opentable.transport.dto.BenchDto;
import com.example.opentable.transport.dto.CheckAvailabilityDto;

public interface TableOrderDao {

	List<BenchDto> checkAvailability(CheckAvailabilityDto checkAvailabilityDto);

	
}
