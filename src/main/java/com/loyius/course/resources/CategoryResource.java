package com.loyius.course.resources;

import com.loyius.course.entities.Category;
import com.loyius.course.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    private CategoryService service;

    public CategoryResource(CategoryService service) { this.service = service;};

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> list = service.getCategories();
        if(list.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category obj = service.getCategoryById(id);
        return ResponseEntity.ok().body(obj);
    }
}
