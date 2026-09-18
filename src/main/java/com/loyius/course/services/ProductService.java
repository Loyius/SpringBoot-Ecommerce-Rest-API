package com.loyius.course.services;

import com.loyius.course.entities.Product;
import com.loyius.course.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository productRepository) {this.repository = productRepository;}

    public List<Product> findAll() { return repository.findAll();}

    public  Product findById(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.orElse(null);
    }
}
