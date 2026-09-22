package com.loyius.course.services;

import com.loyius.course.entities.Category;
import com.loyius.course.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getCategories() {
        return repository.findAll();
    }

    public Category getCategoryById(Long id) {
        Optional<Category> category = repository.findById(id);
        return category.orElse(null);
    }
}
