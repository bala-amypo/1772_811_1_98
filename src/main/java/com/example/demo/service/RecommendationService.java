package com.example.SpringPro.service;

import java.time.LocalDate;
import java.util.List;

import com.example.SpringPro.entity.Recommendation;

public interface RecommendationService {

    Recommendation generateRecommendation(Long userId, Recommendation recommendation);

    Recommendation getLatestRecommendation(Long userId);

    List<Recommendation> getRecommendations(Long userId, LocalDate from, LocalDate to);
}
