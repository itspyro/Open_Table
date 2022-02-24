package com.example.opentable.transport.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterUserDto {
	
	private String userName;
	
	@NotEmpty(message = "Email must not be null or empty")
	@Email(message = "Email should be a valid email format")
	private String userEmail;

	@NotEmpty(message = "Password must not be null or empty")
	@Size(min = 8, message = "Password should have at least 8 characters")
	private String password;

	private String userPhoneNumber;
	
	private String roleName;

	public RegisterUserDto() {
		super();
	}

	public RegisterUserDto(String userName, String userEmail, String password, String userPhoneNumber,
			String roleName) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.userPhoneNumber = userPhoneNumber;
		this.roleName = roleName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
}
