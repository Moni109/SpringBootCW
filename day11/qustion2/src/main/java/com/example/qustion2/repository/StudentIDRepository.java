package com.example.qustion2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.qustion2.model.StudentIDCard;

public interface StudentIDRepository extends JpaRepository<StudentIDCard,Long>{

    
}
