package com.coderscampus.RecipeFinder.service;

import com.coderscampus.RecipeFinder.domain.Recipe;
import com.coderscampus.RecipeFinder.repo.RecipeRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.function.Predicate;
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
        return filterRecipes(Recipe::getGlutenFree);
    }

    public Collection<Recipe> getVeganRecipes() {
        return filterRecipes(Recipe::getVegan);
    }

    public Collection<Recipe> getVeganAndGlutenFreeRecipes() {
        return filterRecipes(recipe -> recipe.getVegan() && recipe.getGlutenFree());
    }

    public Collection<Recipe> getVegetarianRecipes() {
        return filterRecipes(Recipe::getVegetarian);
    }

    private Collection<Recipe> filterRecipes(Predicate<Recipe> predicate) {
        return recipeRepository.getAllRecipes().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
