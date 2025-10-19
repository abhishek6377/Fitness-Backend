package com.fitness.service;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaConnectionDetails;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fitness.dao.ActivityRepository;
import com.fitness.dto.ActivityRequest;
import com.fitness.dto.ActivityResponse;
import com.fitness.model.Activity;

import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor
public class ActivityServiceImp implements ActivityService {
	
	
	@Value("${kafka.topic.name}")
	private String topicName;
	
	private ActivityRepository activityRepository;
	private UserValidateService service;
	private KafkaTemplate<String, Activity> kafkaTemplate;

	public ActivityServiceImp(ActivityRepository activityRepository, UserValidateService service,
			KafkaTemplate<String, Activity> kafkaTemplate) {
		this.activityRepository = activityRepository;
		this.service = service;
		this.kafkaTemplate = kafkaTemplate;
	}



	@Override
	public ActivityResponse trackActivity(ActivityRequest activityRequest) {
		if(activityRequest == null)  return null;
		
		System.out.println(activityRequest.toString());
		
		boolean validateUser = service.validateUser(activityRequest.getUserId());
		if(!validateUser) {
			throw new RuntimeException("Invalid UserId "+activityRequest.getUserId());
		}
		
		Activity activity = new Activity();
		activity.setActivitytype(activityRequest.getActivitytype());
		activity.setCaloriesburned(activityRequest.getCaloriesburned());
		activity.setDuration(activityRequest.getDuration());
		activity.setAdditionalMetrices(activityRequest.getMetrices());
		activity.setUserId(activityRequest.getUserId());
//		activity.setStDateTime(activityRequest.getStDateTime());
//		activity.setUpdatedAt(activityRequest.getUpdatedAt());
		
		Activity save = activityRepository.save(activity);
		if(save==null) return null;
		
		try {
			kafkaTemplate.send(topicName,save.getUserId(),save);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ActivityResponse activityResponse  = new ActivityResponse();
		activityResponse.setActivitytype(save.getActivitytype());
		activityResponse.setCaloriesburned(save.getCaloriesburned());
		activityResponse.setDuration(save.getDuration());
		activityResponse.setAdditionalMetrices(save.getAdditionalMetrices());
		activityResponse.setDuration(save.getDuration());
		activityResponse.setId(save.getId());
		activityResponse.setStDateTime(save.getStartDate());
		activityResponse.setUpdatedAt(save.getUpdatedAt());
		activityResponse.setUserId(save.getUserId());
		
		return activityResponse;
	}

	@Override
	public List<ActivityResponse> getUserId(String userId) {
		if(userId==null ||  userId.isBlank()) return List.of();
		
		 List<Activity> byUserId = activityRepository.findByUserId(userId);
			if(byUserId==null || byUserId.size()==0) return null;
			
			List<ActivityResponse> activityResonse = new ArrayList<>();
			
			for (Activity save : byUserId) {
				
				ActivityResponse activityResponse  = new ActivityResponse();
				activityResponse.setActivitytype(save.getActivitytype());
				activityResponse.setCaloriesburned(save.getCaloriesburned());
				activityResponse.setDuration(save.getDuration());
				activityResponse.setAdditionalMetrices(save.getAdditionalMetrices());
				activityResponse.setDuration(save.getDuration());
				activityResponse.setId(save.getId());
				activityResponse.setStDateTime(save.getStartDate());
				activityResponse.setUpdatedAt(save.getUpdatedAt());
				activityResponse.setUserId(save.getUserId());
				activityResonse.add(activityResponse);
			}
			return activityResonse;
		
	}

}
