package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.MicroLesson;

public interface LessonService {

    MicroLesson addLesson(Long courseId, MicroLesson lesson);

    MicroLesson updateLesson(Long lessonId, MicroLesson lesson);

    MicroLesson getLesson(Long lessonId);

    List<MicroLesson> findLessonsByFilters(
            String difficulty,
            String contentType
    );
}
