package com.fitness.dto;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fitness.model.ActivityType;

import lombok.Data;


@Data
public class ActivityRequest {
	
	
	private String id;
	private String userId;
	private ActivityType activitytype;
	private Integer duration;
	private Integer caloriesburned;
	
	@CreatedDate
	private LocalDateTime stDateTime;
	
	@Field("metrices")
	private Map<String,Object> metrices;
	@LastModifiedBy
	private LocalDateTime updatedAt;

}
