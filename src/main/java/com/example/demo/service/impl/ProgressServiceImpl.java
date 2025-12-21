package com.example.SpringPro.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringPro.entity.MicroLesson;
import com.example.SpringPro.entity.Progress;
import com.example.SpringPro.entity.User;
import com.example.SpringPro.repository.MicroLessonRepository;
import com.example.SpringPro.repository.ProgressRepository;
import com.example.SpringPro.repository.UserRepository;
import com.example.SpringPro.service.ProgressService;

@Service
public class ProgressServiceImpl implements ProgressService {

    private final ProgressRepository progressRepository;
    private final UserRepository userRepository;
    private final MicroLessonRepository lessonRepository;

    public ProgressServiceImpl(ProgressRepository progressRepository,UserRepository userRepository,MicroLessonRepository lessonRepository) {

        this.progressRepository = progressRepository;
        this.userRepository = userRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Progress recordProgress(Long userId, Long lessonId, Progress progress) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        MicroLesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        
        if (progress.getProgressPercent() < 0 || progress.getProgressPercent() > 100) {
            throw new RuntimeException("Progress percent must be between 0 and 100");
        }

        if ("COMPLETED".equals(progress.getStatus())
                && progress.getProgressPercent() != 100) {
            throw new RuntimeException("Completed status must have 100% progress");
        }

        Progress existing = progressRepository
                    .findByUserIdAndMicroLessonId(userId, lessonId)
                    .orElse(null);


        if (existing != null) {
            existing.setStatus(progress.getStatus());
            existing.setProgressPercent(progress.getProgressPercent());
            existing.setScore(progress.getScore());
            return progressRepository.save(existing);
        }

        progress.setUser(user);
        progress.setMicroLesson(lesson);
        return progressRepository.save(progress);
    }

    @Override
    public Progress getProgress(Long userId, Long lessonId) {
        return progressRepository.findByUserIdAndMicroLessonId(userId, lessonId)
                .orElseThrow(() -> new RuntimeException("Progress not found"));
    }

    @Override
    public List<Progress> getUserProgress(Long userId) {
        return progressRepository.findByUserId(userId);
    }
}
