// SurveyService.java remains the same, but let's add better error handling:
package com.JavaProject.SurveyProject.Service;

import com.JavaProject.SurveyProject.Model.SurveyResponse;
import com.JavaProject.SurveyProject.Repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository repository;

    // Create survey
    public SurveyResponse saveSurvey(SurveyResponse survey) {
        if (survey.getEmail() == null || survey.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        return repository.save(survey);
    }

    // Read survey by email
    public SurveyResponse getSurveyByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        return repository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("No survey found for email: " + email));
    }

    // Update survey by email
    public SurveyResponse updateSurveyByEmail(String email, SurveyResponse updatedSurvey) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        SurveyResponse existingSurvey = getSurveyByEmail(email);

        return repository.save(existingSurvey.toBuilder()
                .firstName(updatedSurvey.getFirstName())
                .lastName(updatedSurvey.getLastName())
                .streetAddress(updatedSurvey.getStreetAddress())
                .city(updatedSurvey.getCity())
                .state(updatedSurvey.getState())
                .zip(updatedSurvey.getZip())
                .telephoneNumber(updatedSurvey.getTelephoneNumber())
                .surveyDate(updatedSurvey.getSurveyDate())
                .likedMost(updatedSurvey.getLikedMost())
                .interestSource(updatedSurvey.getInterestSource())
                .recommendationLikelihood(updatedSurvey.getRecommendationLikelihood())
                .build());
    }

    // Delete survey by email
    public void deleteSurveyByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        SurveyResponse existingSurvey = getSurveyByEmail(email);
        repository.delete(existingSurvey);
    }
}