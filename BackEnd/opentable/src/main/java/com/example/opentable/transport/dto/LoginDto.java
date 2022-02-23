package com.example.opentable.transport.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginDto {

	@NotEmpty(message = "Email must not be null or empty")
	@Email(message = "Email should be a valid email format")
	private String userEmail;
	
	@NotEmpty(message = "Password must not be null or empty")
	@Size(min = 8, message = "Password should have at least 8 characters")
	private String password;

	public LoginDto() {
		super();
	}

	public LoginDto(String userEmail, String password) {
		super();
		this.userEmail = userEmail;
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
