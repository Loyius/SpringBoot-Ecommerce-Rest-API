package com.loyius.course.services;

import com.loyius.course.entities.Product;
import com.loyius.course.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository productRepository) { this.repository = productRepository;}

    public List<Product> getProducts() { return repository.findAll();}

    public  Product getProductById(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.orElse(null);
    }
}
