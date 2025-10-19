package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Activity;
import com.example.demo.model.Recommadation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class ActivityAIService {
	
	
	public GeminiModel geminiModel;
	
	
	public Recommadation generateRecommadation(Activity activity) {
		String prompt = createPromptForActivity(activity);
		log.info("Response of ai {}",geminiModel.getRecommendations(prompt));
		String response = geminiModel.getRecommendations(prompt);
		log.info("Response from Gemini AI: {}", response);
		 return processApiResponse(activity,response);
	}


	 private Recommadation processApiResponse(Activity activity, String response) {
		// TODO Auto-generated method stub
		 Recommadation recommadation = new Recommadation();
		 ObjectMapper mapper = new ObjectMapper();
		 try {
			 JsonNode tree = mapper.readTree(response);
			 tree.path("candidates").get(0).path("content").get("parts")
			 .get(0).get("text");
			 
			 String aiText = tree.asText();
			// Now populate Recommadation
	            recommadation.setActivityId(activity.getId());
	            recommadation.setUserId(activity.getUserId()); // Assuming you have userId in Activity
	            recommadation.setDateTime(LocalDateTime.now());
	            recommadation.setRecommadation(aiText);

	            // Optionally split or categorize suggestions, if AI response includes lists
	            // For now, just dummy placeholders:
	            List<String> suggestions = extractListFromText(aiText, "suggestion");
	            List<String> improvements = extractListFromText(aiText, "improvement");
	            List<String> safety = extractListFromText(aiText, "safety");

	            recommadation.setSuggestions(suggestions);
	            recommadation.setImprovements(improvements);
	            recommadation.setSafety(safety);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
		return recommadation;
	}
	 
	 private List<String> extractListFromText(String text, String keyword) {
		    List<String> result = new ArrayList();
		    if (text == null || text.isBlank()) return result;

		    String[] lines = text.split("\n");
		    for (String line : lines) {
		        if (line.toLowerCase().contains(keyword.toLowerCase())) {
		            result.add(line.trim());
		        }
		    }
		    return result;
		}



	private String createPromptForActivity(Activity activity) {
	        return String.format("Give some recommendations based on the activity: %s with description: %s",
	                activity.getActivitytype(), activity.getAdditionalMetrices());
	    }
}
