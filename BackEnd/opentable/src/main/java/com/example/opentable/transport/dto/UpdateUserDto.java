package com.example.opentable.transport.dto;

public class UpdateUserDto {

	private Integer userId;

	private String userName;

	private String userPhoneNumber;
	
	private String roleName;

	public UpdateUserDto() {
		super();
	}

	public UpdateUserDto(Integer userId, String userName, String userPhoneNumber, String roleName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.roleName = roleName;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
