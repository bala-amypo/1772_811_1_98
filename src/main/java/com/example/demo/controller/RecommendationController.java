package com.example.SpringPro.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.SpringPro.entity.Recommendation;
import com.example.SpringPro.service.RecommendationService;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }


    @PostMapping("/generate")
    public Recommendation generateRecommendation(
            @RequestParam Long userId,
            @RequestBody Recommendation recommendation) {

        return recommendationService.generateRecommendation(userId, recommendation);
    }

   
    @GetMapping("/latest")
    public Recommendation getLatest(@RequestParam Long userId) {
        return recommendationService.getLatestRecommendation(userId);
    }


    @GetMapping("/user/{userId}")
    public List<Recommendation> getByUser(
            @PathVariable Long userId,
            @RequestParam LocalDate from,
            @RequestParam LocalDate to) {

        return recommendationService.getRecommendations(userId, from, to);
    }
}
