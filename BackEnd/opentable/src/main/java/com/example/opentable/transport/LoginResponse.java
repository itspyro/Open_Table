package com.example.opentable.transport;

public class LoginResponse extends ResponseMessage {

	private String token;

	public LoginResponse() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
