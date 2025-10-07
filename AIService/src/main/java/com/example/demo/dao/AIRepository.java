package com.example.demo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Recommadation;

@Repository
public interface AIRepository extends MongoRepository<Recommadation, String> {
	
	List<Recommadation> findByUserId(String userId);
	
	Recommadation findByActivityId(String activityId);

}
