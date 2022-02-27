package com.example.opentable.transport.dto;

public class UserDto {
	
	private Integer userId;

	private String userName;

	private String userPhoneNumber;

	private String userEmail;
	
	private String profilePhoto;
	
	private String roleName;

	public UserDto() {
		super();
	}
	
	public UserDto(Integer userId, String userName, String userPhoneNumber, String userEmail, String profilePhoto,
			String roleName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.userEmail = userEmail;
		this.profilePhoto = profilePhoto;
		this.roleName = roleName;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
}
