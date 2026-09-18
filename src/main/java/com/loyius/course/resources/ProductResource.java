package com.loyius.course.resources;

import com.loyius.course.entities.Product;
import com.loyius.course.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ProductResource {
    private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> list = productService.findAll();
        if(list.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "{/id}")
    public ResponseEntity<Product> getProduct(@PathVariable(value = "id") Long id) {
        Product obj = productService.findById(id);
        if(obj== null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(obj);
    }
}
