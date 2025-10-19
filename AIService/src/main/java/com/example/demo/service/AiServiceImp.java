package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.AIRepository;
import com.example.demo.model.Recommadation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiServiceImp implements AIService {
	
	private final AIRepository aiRepository;

	@Override
	public List<Recommadation> getUserRecommadation(String userid) {
		return aiRepository.findByUserId(userid);
	}

	@Override
	public Recommadation getactivityrecommdation(String activityId) {
		return aiRepository.findByActivityId(activityId);
	}

}
