package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Recommadation;

public interface AIService {
	
	List<Recommadation> getUserRecommadation(String userid);
	
	Recommadation getactivityrecommdation(String activityId);

}
