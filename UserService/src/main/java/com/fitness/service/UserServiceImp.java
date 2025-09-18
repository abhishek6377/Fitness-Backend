package com.fitness.service;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import com.fitness.dao.UserRepository;
import com.fitness.dto.RegisterRequest;
import com.fitness.dto.UserResponse;
import com.fitness.model.User;

public class UserServiceImp implements UserService {
	
	 @Autowired
	 UserRepository repository;

	@Override
	public UserResponse register(RegisterRequest entity) throws Exception {
		
		if (repository.existsByEmail(entity.getEmail())) {
		    throw new Exception("Email already exists");
		}

		User user = new User();
		user.setFirstName(entity.getFirstName());
		user.setLastName(entity.getLastName());
		user.setEmail(entity.getEmail());
		user.setPassword(entity.getPassword());

		User savedUser = repository.save(user);

		UserResponse response = new UserResponse();
		response.setId(savedUser.getId());
		response.setEmail(savedUser.getEmail());
		response.setFirstName(savedUser.getFirstName());
		response.setLastName(savedUser.getLastName());
		response.setCreatedOn(savedUser.getCreatedOn());
		return response;
	}

	@Override
	public UserResponse getProfile(String userid) {
		User savedUser=null;
		try {
			savedUser = repository.findById(userid).orElseThrow(()-> new Exception("User not found"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserResponse response = new UserResponse();
		response.setId(savedUser.getId());
		response.setEmail(savedUser.getEmail());
		response.setFirstName(savedUser.getFirstName());
		response.setLastName(savedUser.getLastName());
		response.setCreatedOn(savedUser.getCreatedOn());
		return response;
	}

}
