package com.example.opentable.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.service.PhotoService;
import com.example.opentable.transport.PhotoDetailsResponse;
import com.example.opentable.transport.ResponseMessage;
import com.example.opentable.transport.dto.CreatePhotoDto;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
	
	
	@Autowired
	PhotoService photoService;
	
	@GetMapping("/")
	public ResponseEntity<PhotoDetailsResponse> getAllPhotos(){
		PhotoDetailsResponse response = new PhotoDetailsResponse();
		try {
			response.setPhotos(photoService.getAllPhotos());
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successfull");
		}
		catch(Exception e) {
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setPhotos(null);
			response.setResponseMessage(e.getMessage());
		}
		return new ResponseEntity<PhotoDetailsResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping("/restaurant/{id}")
	public ResponseEntity<PhotoDetailsResponse> getRestaurantPhotos(){
		PhotoDetailsResponse response = new PhotoDetailsResponse();
		try {
			response.setPhotos(photoService.getAllPhotos());
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successfull");
		}
		catch(Exception e) {
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setPhotos(null);
			response.setResponseMessage(e.getMessage());
		}
		return new ResponseEntity<PhotoDetailsResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PhotoDetailsResponse> getPhotoById(@PathVariable(value = "id") int photoId){
		PhotoDetailsResponse response = new PhotoDetailsResponse();
		try {
			response.setPhotos(photoService.getPhotoById(photoId));
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage("Successfull");
		}
		catch(Exception e) {
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setPhotos(null);
			response.setResponseMessage(e.getMessage());
		}
		return new ResponseEntity<PhotoDetailsResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> insertPhoto(@RequestBody CreatePhotoDto createPhotoDto) {
		ResponseMessage response = new ResponseMessage();
		try {
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage(String.format("Photo with id %d created", photoService.createPhoto(createPhotoDto)));
		}
		catch(Exception e) {
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
		return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/restaurant/{id}/delete/{id2}")
	public void deletePhoto(@PathVariable(value = "id") int id,@PathVariable(value = "id2") int id2) {
		
	}
}
