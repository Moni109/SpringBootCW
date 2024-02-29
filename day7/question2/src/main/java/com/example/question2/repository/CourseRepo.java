package com.example.question2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.question2.model.Course;

public interface CourseRepo extends JpaRepository<Course,Integer> {

     @Query("SELECT c FROM Course c where p.courseName=?1")
    List<Course> findByCourseName(String coursename);
}
