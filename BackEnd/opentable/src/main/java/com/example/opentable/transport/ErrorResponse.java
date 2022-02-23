package com.example.opentable.transport;

import java.util.List;

public class ErrorResponse extends ResponseMessage {

	private List<String> details;

	public ErrorResponse() {
		super();
	}
	
	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
	
}
