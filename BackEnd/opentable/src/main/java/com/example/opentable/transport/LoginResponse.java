package com.example.opentable.transport;

public class LoginResponse extends ResponseMessage {

	private int userId;
	
	private String token;

	public LoginResponse() {
		super();
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
