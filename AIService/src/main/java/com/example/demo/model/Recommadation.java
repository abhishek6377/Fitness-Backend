package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recommadation {
	
	@Id
	private String id;
	private String activityId;
	private String userId;
	private String recommadation;
	List<String>  improvements;
	List<String> suggestions;
	List<String>  safety;
	@CreatedDate
	private LocalDateTime dateTime;

}
