package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AIRepository;
import com.example.demo.model.Activity;
import com.example.demo.model.Recommadation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActivityMessageListner {
	
	private final ActivityAIService activityAIService;
	private final AIRepository aiRepository;
	
	@KafkaListener(topics = "${kafka.topic.name}")
	public void processActitvity(Activity activity) {
		log.info("Received  Activity for procesing : {}",activity.getUserId());
		try {
			Recommadation recommadation = activityAIService.generateRecommadation(activity);
			Recommadation save = aiRepository.save(recommadation);
			System.out.println(save.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	

}
