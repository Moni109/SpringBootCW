package com.example.question2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.question2.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    
} 
