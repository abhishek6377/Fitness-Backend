package com.fitness.dao;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fitness.model.Activity;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {
    // List<Activity> findByType(String type);
	
	List<Activity> findByUserId(String userId);
}
