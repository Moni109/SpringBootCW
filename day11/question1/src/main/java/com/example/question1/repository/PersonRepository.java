package com.example.question1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.question1.model.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {

    
} 
