package com.fitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.dto.RegisterRequest;
import com.fitness.dto.UserResponse;
import com.fitness.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/save")
	public ResponseEntity<UserResponse> userSave(@RequestBody RegisterRequest entity) {
		//TODO: process POST request
		
		return ResponseEntity.ok(userService.register(entity));
	}
	

}
