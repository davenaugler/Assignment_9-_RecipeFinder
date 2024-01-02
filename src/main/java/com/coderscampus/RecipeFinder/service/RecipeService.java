package com.coderscampus.RecipeFinder.service;

import com.coderscampus.RecipeFinder.domain.Recipe;
import com.coderscampus.RecipeFinder.repo.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Collection<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }

    public Collection<Recipe> getGlutenFreeRecipes() {
        return recipeRepository.getAllRecipes().stream()
                .filter(Recipe::getGlutenFree)
                .collect(Collectors.toList());
    }

    public Collection<Recipe> getVeganRecipes() {
        return recipeRepository.getAllRecipes().stream()
                .filter(Recipe::getVegan)
                .collect(Collectors.toList());
    }

    public Collection<Recipe> getVeganAndGlutenFreeRecipes() {
        return recipeRepository.getAllRecipes().stream()
                .filter(recipe -> recipe.getVegan() && recipe.getGlutenFree())
                .collect(Collectors.toList());
    }

    public Collection<Recipe> getVegetarianRecipes() {
        return recipeRepository.getAllRecipes().stream()
                .filter(Recipe::getVegetarian)
                .collect(Collectors.toList());
    }
}
