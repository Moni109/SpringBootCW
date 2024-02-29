package com.example.question3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.question3.model.Student;

public interface StudentRepo extends JpaRepository<Student,Long> {
 
    List<Student> findByMarksGreaterThan(int mark);
   
    List<Student> findByMarksLessThan(int mark);

    
}
