package com.example.question1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.question1.model.Person;

public interface PersonRepo extends JpaRepository<Person,Integer> {
    List<Person> findByAge(int age);

}
