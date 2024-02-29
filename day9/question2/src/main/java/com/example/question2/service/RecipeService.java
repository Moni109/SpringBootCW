package com.example.question2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.question2.model.Recipe;
import com.example.question2.repository.RecipeRepo;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepo recipeRepo;

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepo.save(recipe);
    }

    public List<Recipe> getRecipeByName(String recipeName) {
        return recipeRepo.findByRecipeName(recipeName);
    }

    public Recipe getRecipeById(int recipeId) {
        return recipeRepo.findById(recipeId).orElse(null);
    }
}
