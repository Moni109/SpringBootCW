package com.example.qustion2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.qustion2.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    
}
