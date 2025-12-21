package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.MicroLesson;
import com.example.demo.service.LessonService;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping("/course/{courseId}")
    public MicroLesson createLesson(
            @PathVariable Long courseId,
            @RequestBody MicroLesson lesson) {

        return lessonService.addLesson(courseId, lesson);
    }

    @PutMapping("/{lessonId}")
    public MicroLesson updateLesson(
            @PathVariable Long lessonId,
            @RequestBody MicroLesson lesson) {

        return lessonService.updateLesson(lessonId, lesson);
    }

    @GetMapping("/{lessonId}")
    public MicroLesson getLessonById(@PathVariable Long lessonId) {
        return lessonService.getLesson(lessonId);
    }

    @GetMapping("/search")
    public List<MicroLesson> searchLessons(
            @RequestParam String difficulty,
            @RequestParam String contentType) {

        return lessonService.findLessonsByFilters(difficulty, contentType);
    }
}
