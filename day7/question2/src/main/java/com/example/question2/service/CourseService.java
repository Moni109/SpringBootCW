package com.example.question2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.question2.model.Course;
import com.example.question2.repository.CourseRepo;

@Service
public class CourseService {
    private CourseRepo courseRepo;
    public CourseService(CourseRepo courseRepo){
        this.courseRepo=courseRepo;
    }

    public Course postCourse(Course course){
        return courseRepo.save(course);
    }

    public List<Course> getCourses(){
        return courseRepo.findAll();
    }

    public List<Course> findCoursename(String courname){
        return courseRepo.findByCourseName(courname);
    }
}
