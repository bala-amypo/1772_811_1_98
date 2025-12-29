package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    private String password;

    private String role = "LEARNER";

    private String preferredLearningStyle;

    private LocalDate createdAt;

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDate.now();
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getRole() {
        return role;
    }
 
    public void setRole(String role) {
        this.role = role;
    }
 
    public String getPreferredLearningStyle() {
        return preferredLearningStyle;
    }
 
    public void setPreferredLearningStyle(String preferredLearningStyle) {
        this.preferredLearningStyle = preferredLearningStyle;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
