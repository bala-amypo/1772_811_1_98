package com.example.SpringPro.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "progress")
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    private MicroLesson microLesson;

    private String status; 

    private int progressPercent; 
    private BigDecimal score;

    private LocalDateTime lastAccessedAt;

    @PrePersist
    public void setLastAccessedAt() {
        this.lastAccessedAt = LocalDateTime.now();
    }

    public Progress() {}

  

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MicroLesson getMicroLesson() {
        return microLesson;
    }

    public void setMicroLesson(MicroLesson microLesson) {
        this.microLesson = microLesson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(int progressPercent) {
        this.progressPercent = progressPercent;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public LocalDateTime getLastAccessedAt() {
        return lastAccessedAt;
    }
}
