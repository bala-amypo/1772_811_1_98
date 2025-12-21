package com.example.SpringPro.service.impl;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringPro.entity.Recommendation;
import com.example.SpringPro.entity.User;
import com.example.SpringPro.repository.RecommendationRepository;
import com.example.SpringPro.repository.UserRepository;
import com.example.SpringPro.service.RecommendationService;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;

    public RecommendationServiceImpl(
            RecommendationRepository recommendationRepository,
            UserRepository userRepository) {
        this.recommendationRepository = recommendationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Recommendation generateRecommendation(Long userId, Recommendation recommendation) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (recommendation.getConfidenceScore().doubleValue() < 0.0 ||
            recommendation.getConfidenceScore().doubleValue() > 1.0) {
            throw new RuntimeException("Confidence score must be between 0.0 and 1.0");
        }

        recommendation.setUser(user);

        if (recommendation.getRecommendedLessonIds() == null) {
            recommendation.setRecommendedLessonIds("1,2,3");
        }

        return recommendationRepository.save(recommendation);
    }

    @Override
    public Recommendation getLatestRecommendation(Long userId) {
        return recommendationRepository.findTopByUserIdOrderByGeneratedAtDesc(userId)
                .orElseThrow(() -> new RuntimeException("No recommendation found"));
    }

    @Override
    public List<Recommendation> getRecommendations(Long userId, LocalDate from, LocalDate to) {

        LocalDateTime start = from.atStartOfDay();
        LocalDateTime end = to.atTime(23, 59, 59);

        return recommendationRepository.findByUserIdAndGeneratedAtBetween(
                userId, start, end);
    }
}
