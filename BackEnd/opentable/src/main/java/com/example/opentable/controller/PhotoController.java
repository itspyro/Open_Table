package com.example.opentable.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.repository.entity.Photo;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
	
	@GetMapping("/")
	public List<Photo> getAllPhotos(){
		return null;
	}
	
	@GetMapping("/restaurant/{id}")
	public List<Photo> getRestaurantPhotos(){
		return null;
	}
	
	@PostMapping("/restaurant/{id}/insert")
	public void insertPhoto(@PathVariable(value = "id") int id, @RequestBody Photo photo) {
		
	}
	
	@DeleteMapping("/restaurant/{id}/delete/{id2}")
	public void deletePhoto(@PathVariable(value = "id") int id,@PathVariable(value = "id2") int id2) {
		
	}
}
