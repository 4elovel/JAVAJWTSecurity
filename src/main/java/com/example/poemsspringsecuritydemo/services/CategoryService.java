package com.example.poemsspringsecuritydemo.services;

import com.example.poemsspringsecuritydemo.DTOs.CategoryDTO;
import com.example.poemsspringsecuritydemo.mappers.CategoryMapper;
import com.example.poemsspringsecuritydemo.repositories.CategoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getCategoriesContainingWords(String words) {
        return categoryRepository.findByNameContaining(words).stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getTopCategories() {
        return categoryRepository.findTopCategories().stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getCategoriesWithMostPoems() {
        return categoryRepository.findCategoriesWithMostPoems().stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }
}
