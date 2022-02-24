package com.example.opentable.transport;

public class LoginResponse extends ResponseMessage {

	private Integer userId;

	public LoginResponse() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
