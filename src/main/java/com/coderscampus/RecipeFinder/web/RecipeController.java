package com.coderscampus.RecipeFinder.web;

import com.coderscampus.RecipeFinder.service.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class RecipeController {


    private FileService fileService;

    /**
     * Using Constructor over `@Autowired` for dependency injection in Spring Application
     * for its benefits in immutability, clarity, testability, and safety.
     * It aligns well with best practices for writing clean, maintainable code.
     */
    public RecipeController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("")
    public List<String> readLines() throws IOException {
        return fileService.readFile();
    }

}
