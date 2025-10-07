package com.fitness.service;

import com.fitness.dto.RegisterRequest;
import com.fitness.dto.UserResponse;

public interface UserService {

	 UserResponse register(RegisterRequest entity) throws Exception;
	 
	 UserResponse  getProfile(long userid);
	 
	 boolean existsByUser(long userid);
	
	

}
