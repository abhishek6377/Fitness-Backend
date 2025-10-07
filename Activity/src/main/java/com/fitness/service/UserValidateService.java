
package com.fitness.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserValidateService {
	
	
	private final WebClient client;
	
	
	public boolean validateUser(String id) {
		try {
			return client.get().uri("/api/user/{id}/validate", id).retrieve().bodyToMono(Boolean.class).block();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
