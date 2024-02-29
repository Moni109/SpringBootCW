package com.example.question2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.question2.model.Recipe;

public interface RecipeRepo extends JpaRepository<Recipe,Integer> {
    List<Recipe> findByRecipeName(String recipeName);

    
}
