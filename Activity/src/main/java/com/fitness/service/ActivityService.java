package com.fitness.service;

import java.util.List;

import com.fitness.dto.ActivityRequest;
import com.fitness.dto.ActivityResponse;

public interface ActivityService {
	
	
	 ActivityResponse trackActivity(ActivityRequest activityRequest);
	 
	 List<ActivityResponse> getUserId(String userId);

}
