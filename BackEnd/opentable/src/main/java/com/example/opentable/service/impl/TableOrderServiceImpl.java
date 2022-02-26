package com.example.opentable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.TableOrderDao;
import com.example.opentable.service.TableOrderService;
import com.example.opentable.transport.dto.BenchDto;
import com.example.opentable.transport.dto.CheckAvailabilityDto;


@Service
public class TableOrderServiceImpl implements TableOrderService
{

	@Autowired
	TableOrderDao tableOrderDao;

	@Override
	public List<BenchDto> checkavailability(CheckAvailabilityDto checkAvailabilityDto) throws Exception {
		return tableOrderDao.checkAvailability(checkAvailabilityDto);
	}
	


}
