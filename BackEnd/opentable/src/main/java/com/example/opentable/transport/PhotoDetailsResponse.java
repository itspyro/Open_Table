package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.PhotoDto;

public class PhotoDetailsResponse extends ResponseMessage implements Serializable{

	private static final long serialVersionUID = -5758670102324913965L;

	private List<PhotoDto> photos;

	public PhotoDetailsResponse() {

	}

	public List<PhotoDto> getPhotos() {
		return photos;
	}

	public void setPhotos(List<PhotoDto> photos) {
		this.photos = photos;
	}
	
	
}
