package com.example.SpringPro.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringPro.entity.Course;
import com.example.SpringPro.entity.User;
import com.example.SpringPro.repository.CourseRepository;
import com.example.SpringPro.repository.UserRepository;
import com.example.SpringPro.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseServiceImpl(CourseRepository courseRepository,
                             UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Course createCourse(Course course, Long instructorId) {
        User instructor = userRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        course.setInstructor(instructor);
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long courseId, Course course) {
        course.setId(courseId);
        return courseRepository.save(course);
    }

    @Override
    public List<Course> listCoursesByInstructor(Long instructorId) {
        User instructor = userRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        return courseRepository.findByInstructor(instructor);
    }

    @Override
    public Course getCourse(Long courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }
}
