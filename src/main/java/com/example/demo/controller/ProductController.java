package com.example.demo.controller;

import com.example.demo.repository.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository repo;

    ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product newProduct) {
        return repo.save(newProduct);
    }
}
