package com.example.question3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.question3.model.Language;
@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
    
}
