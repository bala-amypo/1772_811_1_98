package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.MicroLesson;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.MicroLessonRepository;
import com.example.demo.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService {

    private final MicroLessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    public LessonServiceImpl(MicroLessonRepository lessonRepository, CourseRepository courseRepository) {
        this.lessonRepository = lessonRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public MicroLesson addLesson(Long courseId, MicroLesson lesson) {

        if (lesson.getDurationMinutes() <= 0 || lesson.getDurationMinutes() > 15) {
            throw new RuntimeException("Duration must be between 1 and 15 minutes");
        }

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        lesson.setCourse(course);
        return lessonRepository.save(lesson);
    }

    @Override
    public MicroLesson updateLesson(Long lessonId, MicroLesson lesson) {

        MicroLesson existing = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        existing.setTitle(lesson.getTitle());
        existing.setDurationMinutes(lesson.getDurationMinutes());
        existing.setContentType(lesson.getContentType());
        existing.setDifficulty(lesson.getDifficulty());
        existing.setTags(lesson.getTags());

        return lessonRepository.save(existing);
    }

    @Override
    public MicroLesson getLesson(Long lessonId) {
        return lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
    }

    @Override
    public List<MicroLesson> findLessonsByFilters(
            String difficulty,
            String contentType) {

        return lessonRepository.findByDifficultyAndContentType(
                difficulty,
                contentType
        );
    }
}
