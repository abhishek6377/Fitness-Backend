package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Recommadation;
import com.example.demo.service.AIService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ai/recommadations")
public class AIController {
	
	private final AIService aiService;
	
	
	@GetMapping("/user/{userid}")
	public ResponseEntity<List<Recommadation>> getUserRecommadation(@PathVariable String userid) {
		return ResponseEntity.ok(aiService.getUserRecommadation(userid));
	}
	
	@GetMapping("/activity/{activityId}")
	public ResponseEntity<Recommadation> getactivityRecommadation(@PathVariable String activityId){
		return ResponseEntity.ok(aiService.getactivityrecommdation(activityId));
	}

}
