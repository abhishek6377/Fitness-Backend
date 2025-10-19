package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeminiModel {
	
	private final WebClient client;
	
	@Value("${gemini.urlhttps}")
	private String geminiApiUrl;
	
	@Value("${gemini-apikey}")
	private String geminiApiKey;
	
	
	public String getRecommendations(String details) {
		Map<String, Object[]> of = Map.of(
				"contents",new Object[] {
						Map.of("parts", new Object[] {
								Map.of("text",details)
						})
				});
				
			String response =	client.post().uri(geminiApiUrl).header("Content-Type", "application/json")
				.header("x-goog-api-key",geminiApiKey)
				.bodyValue(of)
				.retrieve().bodyToMono(String.class).block();
		return response;
	}
	
	

}
