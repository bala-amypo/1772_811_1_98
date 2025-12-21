package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.MicroLesson;

public interface MicroLessonRepository extends JpaRepository<MicroLesson, Long> {

    List<MicroLesson> findByDifficultyAndContentType(
            String difficulty,
            String contentType
    );
}
