package com.example.opentable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentable.service.TableOrderService;

@RestController
@RequestMapping("api")
public class TableOrderController {

@Autowired
TableOrderService tableOrderService;
	
// @GetMapping("/checkAvailibity/")
// public ResponseEntity<>
}
