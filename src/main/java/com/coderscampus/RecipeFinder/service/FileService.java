package com.coderscampus.RecipeFinder.service;

import com.coderscampus.RecipeFinder.domain.Recipe;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FileService {

    @Value("${file.name}")
    private String fileName;

    private static final Logger logger = Logger.getLogger(FileService.class.getName());

    public Map<Integer, Recipe> readRecipeFile() {
        Map<Integer, Recipe> recipeMap = new HashMap<>();
        int idCounter = 1; // Start ID counter

        try (Reader in = new FileReader(fileName)) {
            CSVFormat csvFormat = CSVFormat.Builder.create()
                    .setHeader()
                    .setSkipHeaderRecord(true)
//                    .setTrim(true)
                    .setIgnoreSurroundingSpaces(true)
                    .setEscape('\\')
//                    .setQuote('"')
                    .build();

            CSVParser parser = csvFormat.parse(in);
            Iterable<CSVRecord> records = parser.getRecords();

            for (CSVRecord record : records) {
                try {
                    Recipe recipe = parseRecipe(record);
                    recipe.setId(idCounter); // Set the ID
                    recipeMap.put(idCounter++, recipe); // Use the counter as the ID
                } catch (IllegalArgumentException e) {
                    System.err.println("Error parsing record: " + e.getMessage() + " Record: " + record);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return recipeMap;
    }

    private Recipe parseRecipe(CSVRecord record) {
        Recipe recipe = new Recipe();

        recipe.setCookingMinutes(parseIntegerFromRecord(record, "Cooking Minutes"));
        recipe.setDairyFree(parseBooleanFromRecord(record, "Dairy Free"));
        recipe.setGlutenFree(parseBooleanFromRecord(record, "Gluten Free"));
        recipe.setInstructions(record.get("Instructions"));
        recipe.setPreparationMinutes(parseDoubleFromRecord(record, "Preparation Minutes"));
        recipe.setPricePerServing(parseDoubleFromRecord(record, "Price Per Serving"));
        recipe.setReadyInMinutes(parseIntegerFromRecord(record, "Ready In Minutes"));
        recipe.setServings(parseIntegerFromRecord(record, "Servings"));
        recipe.setSpoonacularScore(parseDoubleFromRecord(record, "Spoonacular Score"));
        recipe.setTitle(record.get("Title"));
        recipe.setVegan(parseBooleanFromRecord(record, "Vegan"));
        recipe.setVegetarian(parseBooleanFromRecord(record, "Vegetarian"));

        return recipe;
    }

    private int parseIntegerFromRecord(CSVRecord record, String fieldName) {
        try {
            return Integer.parseInt(record.get(fieldName));
        } catch (NumberFormatException e) {
            logParsingError(fieldName, record.get(fieldName)); // Replace with actual logging
            return 0;
        }
    }

    private double parseDoubleFromRecord(CSVRecord record, String fieldName) {
        try {
            return Double.parseDouble(record.get(fieldName));
        } catch (NumberFormatException e) {
            logParsingError(fieldName, record.get(fieldName)); // Replace with actual logging
            return 0.0;
        }
    }

    private boolean parseBooleanFromRecord(CSVRecord record, String fieldName) {
        return Boolean.parseBoolean(record.get(fieldName));
    }


    private void logParsingError(String fieldName, String value) {
        if (value == null || value.isEmpty()) {
            logger.log(Level.WARNING, "Parsing error: Field ''{0}'' is missing or empty", fieldName);
        } else {
            logger.log(Level.WARNING, "Parsing error: Could not parse ''{0}'' for field ''{1}''", new Object[]{value, fieldName});
        }
    }
}
