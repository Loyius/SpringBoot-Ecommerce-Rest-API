package com.loyius.course.resources;

import com.loyius.course.entities.Product;
import com.loyius.course.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    private ProductService service;

    public ProductResource(ProductService productService) {
        this.service = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> list = service.getProducts();
        if(list.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(value = "id") Long id) {
        Product obj = service.getProductById(id);
        if(obj== null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(obj);
    }
}
