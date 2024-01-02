package com.coderscampus.RecipeFinder.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Recipe {
    private Integer cookingMinutes;
    private Boolean dairyFree;
    private Boolean glutenFree;
    private String instructions;
    private Double preparationMinutes;
    private Double pricePerServing;
    private Integer readyInMinutes;
    private Integer servings;
    private Double spoonacularScore;
    private String title;
    private Boolean vegan;
    private Boolean vegetarian;
    private Integer id;
}
