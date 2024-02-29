package com.example.question1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.question1.model.Children;

public interface ChildrenRepo extends JpaRepository<Children,Integer> {

    
}
