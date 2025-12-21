package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.Recommendation;

public interface RecommendationService {

    Recommendation generateRecommendation(Long userId, Recommendation recommendation);

    Recommendation getLatestRecommendation(Long userId);

    List<Recommendation> getRecommendations(Long userId, LocalDate from, LocalDate to);
}
