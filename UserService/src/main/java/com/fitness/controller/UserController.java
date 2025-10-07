package com.fitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.dto.RegisterRequest;
import com.fitness.dto.UserResponse;
import com.fitness.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/save")
	public ResponseEntity<UserResponse> userSave(@RequestBody RegisterRequest entity) throws Exception {
		return ResponseEntity.ok(userService.register(entity));
	}
	
	@GetMapping("/getByUser/{id}")
	public ResponseEntity<UserResponse> userSave(@PathVariable long id) throws Exception {
		return ResponseEntity.ok(userService.getProfile(id));
	}
	
	@GetMapping("/{id}/validate")
	public ResponseEntity<Boolean> validateUser(@PathVariable long id) throws Exception {
		return ResponseEntity.ok(userService.existsByUser(id));
	}
	
	
	
	

}
