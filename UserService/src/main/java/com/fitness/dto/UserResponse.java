package com.fitness.dto;

import java.time.LocalDateTime;

import com.fitness.model.UserRole;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserResponse {
	
	private String id;
	private String email;
	private String 	password;
	private String firstName;
	private String lastName;
	private UserRole role = UserRole.USER;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

}

