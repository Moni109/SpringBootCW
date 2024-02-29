package com.example.question1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.question1.model.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine,Integer> {
    
}
