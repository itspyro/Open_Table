package com.example.opentable.transport.dto;

public class UserPhotoDto {
	
	private int userId;
	
	private String photoUrl;

	public UserPhotoDto() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}
