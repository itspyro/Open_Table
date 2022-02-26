package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.repository.entity.Bench;
import com.example.opentable.transport.dto.BenchDto;

public class BenchDetailsResponse extends ResponseMessage implements Serializable {

	private static final long serialVersionUID = 8896881208042362457L;
	
	public List<BenchDto> benches;

	public BenchDetailsResponse() {
		
	}

	public List<BenchDto> getBenches() {
		return benches;
	}

	public void setBenches(List<BenchDto> list) {
		this.benches = list;
	}	
	

}
