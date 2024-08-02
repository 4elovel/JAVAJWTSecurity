package com.example.poemsspringsecuritydemo.controllers;

import com.example.poemsspringsecuritydemo.DTOs.CategoryDTO;
import com.example.poemsspringsecuritydemo.DTOs.PoemDTO;
import com.example.poemsspringsecuritydemo.services.CategoryService;
import com.example.poemsspringsecuritydemo.services.PoemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PoemService poemService;

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/search")
    public List<CategoryDTO> getCategoriesContainingWords(@RequestParam String words) {
        return categoryService.getCategoriesContainingWords(words);
    }

    @GetMapping("/top")
    public List<CategoryDTO> getTopCategories() {
        return categoryService.getTopCategories();
    }

    @GetMapping("/most-poems")
    public List<CategoryDTO> getCategoriesWithMostPoems() {
        return categoryService.getCategoriesWithMostPoems();
    }

    @GetMapping("/{categoryId}/poems/top")
    public List<PoemDTO> getTopPoemsInCategory(@PathVariable Long categoryId) {
        return poemService.getTopPoemsInCategory(categoryId);
    }
}
