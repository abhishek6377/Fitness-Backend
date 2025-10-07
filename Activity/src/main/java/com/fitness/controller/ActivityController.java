package com.fitness.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.dto.ActivityRequest;
import com.fitness.dto.ActivityResponse;
import com.fitness.service.ActivityService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/activity")
public class ActivityController {
    
    private ActivityService activityService;
    
    
    @PostMapping("/save")
    public ResponseEntity<ActivityResponse> saveActivity(@RequestBody ActivityRequest entity) {
        ActivityResponse trackActivity = activityService.trackActivity(entity);
        return ResponseEntity.ok(trackActivity);
    }
    
    
    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<List<ActivityResponse>> getMethodName(@PathVariable String userId) {
    	List<ActivityResponse> userId2 = activityService.getUserId(userId);
    	return ResponseEntity.ok(userId2);
    }
    
}
