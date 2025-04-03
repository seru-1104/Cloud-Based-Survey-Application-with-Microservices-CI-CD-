package com.JavaProject.Project3.controller;

import com.JavaProject.Project3.model.Survey;
import com.JavaProject.Project3.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    // Get all surveys
    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    // Get survey by ID
    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Long id) {
        return surveyRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new survey
    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        return surveyRepository.save(survey);
    }

    // Update an existing survey
    @PutMapping("/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Long id, @RequestBody Survey surveyDetails) {
        return surveyRepository.findById(id)
                .map(survey -> {
                    survey.setFirstName(surveyDetails.getFirstName());
                    survey.setLastName(surveyDetails.getLastName());
                    survey.setStreetAddress(surveyDetails.getStreetAddress());
                    survey.setCity(surveyDetails.getCity());
                    survey.setState(surveyDetails.getState());
                    survey.setZip(surveyDetails.getZip());
                    survey.setPhoneNumber(surveyDetails.getPhoneNumber());
                    survey.setEmail(surveyDetails.getEmail());
                    survey.setSurveyDate(surveyDetails.getSurveyDate());
                    survey.setLikedMost(surveyDetails.getLikedMost());
                    survey.setInterestSource(surveyDetails.getInterestSource());
                    survey.setRecommendationLikelihood(surveyDetails.getRecommendationLikelihood());
                    return ResponseEntity.ok(surveyRepository.save(survey));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a survey
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        if (surveyRepository.existsById(id)) {
            surveyRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
