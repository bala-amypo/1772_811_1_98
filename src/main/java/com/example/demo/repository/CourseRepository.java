package com.example.SpringPro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringPro.entity.Course;
import com.example.SpringPro.entity.User;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByInstructor(User instructor);
}
