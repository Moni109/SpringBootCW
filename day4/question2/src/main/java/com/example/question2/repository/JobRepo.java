package com.example.question2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.question2.model.Job;

public interface JobRepo extends JpaRepository<Job,Integer> {
    
} 
