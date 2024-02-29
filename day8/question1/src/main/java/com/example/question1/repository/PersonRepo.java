package com.example.question1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.question1.model.Person;

public interface PersonRepo extends JpaRepository<Person,Long> {

    @Query("SELECT p FROM Person p WHERE name LIKE ?1")
    List<Person> findByStartName(String name);
    
    @Query("SELECT p FROM Person p WHERE name LIKE ?1")
    List<Person> findByEndName(String name);

}