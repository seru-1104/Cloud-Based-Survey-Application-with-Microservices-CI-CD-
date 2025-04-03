// SurveyController.java
package com.JavaProject.SurveyProject.Controller;

import com.JavaProject.SurveyProject.Model.SurveyResponse;
import com.JavaProject.SurveyProject.Service.SurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/api/surveys")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService service;

    // Create
    @PostMapping
    public ResponseEntity<SurveyResponse> saveSurvey(@RequestBody SurveyResponse survey) {
        return ResponseEntity.ok(service.saveSurvey(survey));
    }

    // Read by email - Path Variable approach
    @GetMapping("/{email}")
    public ResponseEntity<SurveyResponse> getSurveyByEmailPath(@PathVariable String email) {
        log.info("Fetching survey by email (path) = " + email);
        try {
            SurveyResponse survey = service.getSurveyByEmail(email);
            return ResponseEntity.ok(survey);
        } catch (IllegalArgumentException e) {
            log.error("Survey not found for email: " + email, e);
            return ResponseEntity.notFound().build();
        }
    }

    // Update by email
    @PutMapping("/{email}")
    public ResponseEntity<?> updateSurveyByEmail(@PathVariable String email, @RequestBody SurveyResponse survey) {
        try {
            SurveyResponse updatedSurvey = service.updateSurveyByEmail(email, survey);
            return ResponseEntity.ok(updatedSurvey);
        } catch (IllegalArgumentException e) {
            log.error("Error updating survey for email: " + email, e);
            return ResponseEntity.notFound().build();
        }
    }

    // Delete by email
    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteSurveyByEmail(@PathVariable String email) {
        try {
            service.deleteSurveyByEmail(email);
            return ResponseEntity.ok("Survey deleted successfully");
        } catch (IllegalArgumentException e) {
            log.error("Error deleting survey for email: " + email, e);
            return ResponseEntity.notFound().build();
        }
    }
}