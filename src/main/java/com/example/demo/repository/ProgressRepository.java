package com.example.SpringPro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringPro.entity.Progress;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

    Optional<Progress> findByUserIdAndMicroLessonId(Long userId, Long lessonId);

    List<Progress> findByUserId(Long userId);
}
