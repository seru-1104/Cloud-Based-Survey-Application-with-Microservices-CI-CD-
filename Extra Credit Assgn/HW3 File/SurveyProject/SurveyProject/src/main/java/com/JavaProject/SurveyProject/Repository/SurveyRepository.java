package com.JavaProject.SurveyProject.Repository;

import com.JavaProject.SurveyProject.Model.SurveyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<SurveyResponse, Long> {
        Optional<SurveyResponse> findByEmail(String email);

}
