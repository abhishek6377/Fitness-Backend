package com.fitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.dao.UserRepository;
import com.fitness.dto.RegisterRequest;
import com.fitness.dto.UserResponse;
import com.fitness.model.User;

@Service
public class UserServiceImp implements UserService {
	
	 @Autowired
	 UserRepository repository;

	@Override
	public UserResponse register(RegisterRequest entity) throws Exception {
		
		if (repository.existsByEmail(entity.getEmail())) {
		    throw new Exception("Email already exists");
		}

		User user = new User();
		user.setFirstname(entity.getFirstName());
		user.setLastname(entity.getLastName());
		user.setEmail(entity.getEmail());
		user.setPassword(entity.getPassword());
      System.err.println(entity.toString()+"="+entity.getPassword());
		User savedUser = repository.save(user);

		UserResponse response = new UserResponse();
		response.setId(savedUser.getId());
		response.setEmail(savedUser.getEmail());
		response.setPassword(savedUser.getPassword());
		response.setFirstName(savedUser.getFirstname());
		response.setLastName(savedUser.getLastname());
		response.setCreatedOn(savedUser.getCreatedOn());
		return response;
	}

	@Override
	public UserResponse getProfile(long userid) {
		User savedUser=null;
		try {
			savedUser = repository.findById(userid).orElseThrow(()-> new Exception("User not found"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(savedUser.toString());
		UserResponse response = new UserResponse();
		response.setId(savedUser.getId());
		response.setEmail(savedUser.getEmail());
		response.setFirstName(savedUser.getFirstname());
		response.setLastName(savedUser.getLastname());
		response.setCreatedOn(savedUser.getCreatedOn());
		return response;
	}

	@Override
	public boolean existsByUser(long userid) {
		 return repository.existsById(userid);
	}

}
