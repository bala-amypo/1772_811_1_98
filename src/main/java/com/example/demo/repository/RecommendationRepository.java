package com.example.SpringPro.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringPro.entity.Recommendation;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    
    Optional<Recommendation> findTopByUserIdOrderByGeneratedAtDesc(Long userId);


    List<Recommendation> findByUserIdAndGeneratedAtBetween(Long userId,LocalDateTime from,LocalDateTime to);
}
