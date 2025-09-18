package com.fitness.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
	
	@Size(max = 24)
	@Column(nullable = false)
	@NotBlank(message = "Email is not be blank")
	private String email;
	
	@Size(min = 6)
	private String password;
	private String firstName;
	private String lastName;
	

}
