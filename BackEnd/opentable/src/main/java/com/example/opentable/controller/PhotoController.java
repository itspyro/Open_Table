package com.example.opentable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.repository.PhotoRepository;
import com.example.opentable.repository.RestaurantRepository;
import com.example.opentable.repository.entity.Photo;
import com.example.opentable.repository.entity.Restaurant;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
	
	@Autowired 
	PhotoRepository photoRepository;
	
	@Autowired
	RestaurantRepository restaurant;
	
	@GetMapping("/")
	public List<Photo> getAllPhotos(){
		return photoRepository.findAll();
	}
	
	@GetMapping("/restaurant/{id}")
	public List<Photo> getRestaurantPhotos(){
		return null;
	}
	
	@PostMapping("/{id}/insert")
	public void insertPhoto(@PathVariable(value = "id") int id, @RequestBody Photo photo) {
		Restaurant res = restaurant.getById(id);
		photo.setRestaurant(res);
		photoRepository.save(photo);
	}
	
	@DeleteMapping("/restaurant/{id}/delete/{id2}")
	public void deletePhoto(@PathVariable(value = "id") int id,@PathVariable(value = "id2") int id2) {
		
	}
}
