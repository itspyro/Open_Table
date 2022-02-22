package com.example.opentable.transport.dto;

public class PhotoDto {
	
	private int photoId;
	
	private String photoUrl;

	public PhotoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhotoDto(int photoId, String photoUrl) {
		super();
		this.photoId = photoId;
		this.photoUrl = photoUrl;
	}

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	
	
}
