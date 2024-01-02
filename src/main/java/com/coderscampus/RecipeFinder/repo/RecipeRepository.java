package com.coderscampus.RecipeFinder.repo;

import com.coderscampus.RecipeFinder.domain.Recipe;
import com.coderscampus.RecipeFinder.service.FileService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeRepository {

    private Map<Integer, Recipe> recipeMap = new HashMap<>();
    private final FileService fileService;

    // Constructor for dependency injection
    public RecipeRepository(FileService fileService) {
        this.fileService = fileService;
    }

    public Collection<Recipe> getAllRecipes() {
        if (recipeMap.isEmpty()) {
            Map<Integer, Recipe> recipes = fileService.readRecipeFile();
            recipeMap.putAll(recipes);
        }
        return recipeMap.values();
    }

    // Add a new recipe
//    public void addRecipe(Recipe recipe) {
//        recipeMap.put(recipe.getId(), recipe);
//    }

    // Get a recipe by ID
//    public Recipe getRecipeById(Integer id) {
//        return recipeMap.get(id);
//    }

    // Update an existing recipe
//    public void updateRecipe(Recipe recipe) {
//        if (recipeMap.containsKey(recipe.getId())) {
//            recipeMap.put(recipe.getId(), recipe);
//        } else {
//            // Handle the case where the recipe does not exist
//            // For example, throw an exception or log a message
//        }
//    }

    // Delete a recipe by ID
//    public void deleteRecipe(Integer id) {
//        recipeMap.remove(id);
//    }

}
