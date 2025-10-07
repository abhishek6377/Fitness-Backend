package com.fitness.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.fitness.model.ActivityType;

import lombok.Data;


@Data
public class ActivityResponse {
	
	private String id;
	private String userId;
	private ActivityType activitytype;
	private Integer duration;
	private Integer caloriesburned;
	private LocalDateTime stDateTime;
	private Map<String,Object> additionalMetrices;
	private LocalDateTime updatedAt;

}
