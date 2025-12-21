package com.example.SpringPro.service;

import java.util.List;

import com.example.SpringPro.entity.Progress;

public interface ProgressService {

    Progress recordProgress(Long userId, Long lessonId, Progress progress);

    Progress getProgress(Long userId, Long lessonId);

    List<Progress> getUserProgress(Long userId);
}
