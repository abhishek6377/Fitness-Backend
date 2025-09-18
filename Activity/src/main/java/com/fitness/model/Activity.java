package com.fitness.model;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@Setter
@Getter
@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
	private String id;
	private String userId;
	private ActivityType activityType;
	private Integer duration;
	private Integer caloriesBurned;
	
	@CreatedDate
	private LocalDateTime stDateTime;
	
	@Field("metrices")
	private Map<String,Object> additionalMetrices;
	@LastModifiedBy
	private LocalDateTime updatedAt;

}
