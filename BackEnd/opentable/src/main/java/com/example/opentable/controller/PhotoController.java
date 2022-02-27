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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public ResponseEntity<PhotoDetailsResponse> getRestaurantPhotos(@PathVariable(value = "id") int restaurantId){
		PhotoDetailsResponse response = new PhotoDetailsResponse();
		try {
			response.setPhotos(photoService.getRestaurantPhoto(restaurantId));
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
	
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> insertPhoto(@RequestParam(value = "file") MultipartFile file) {
		ResponseMessage response = new ResponseMessage();
		try {
			if(!file.getContentType().contains("image")) {
				response.setHttpStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				response.setResponseMessage("it is not a image file");
			}
			else {
				response.setHttpStatusCode(HttpStatus.OK.value());	
				CreatePhotoDto photoDto =new CreatePhotoDto();
				response.setResponseMessage(photoService.uploadFile(file));
			}
			
		}
		catch(Exception e) {
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
		return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> createPhoto(@RequestBody CreatePhotoDto photoDto){
		ResponseMessage response = new ResponseMessage();
		try {
			response.setHttpStatusCode(HttpStatus.OK.value());
			response.setResponseMessage(String.format("photo with id %d created", photoService.createPhoto(photoDto)));
		}
		catch(Exception e) {
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage("photo is not created");
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseMessage> deletePhoto(@PathVariable(value = "id") int photoId) {
		ResponseMessage response = new ResponseMessage();
		try {
			int no = photoService.deletePhoto(photoId);
			response.setHttpStatusCode(HttpStatus.OK.value());
			if(no >= 1) {
				response.setResponseMessage("Photo deleted");
			}
			else {
				response.setResponseMessage("Photo not deleted");
			}
		}
		catch(Exception e) {
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponseMessage(e.getMessage());
		}
		return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
	}
}
