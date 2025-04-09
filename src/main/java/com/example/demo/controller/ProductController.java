package com.example.demo.controller;

import com.example.demo.repository.Product;
import com.example.demo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductRepository repo;

    ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = repo.findAll();
        log.info("Result of get products endpoint:" + products.toString());
        return products;
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product newProduct) {
        Product result = repo.save(newProduct);
        log.info("Successfully added product: " + result.toString());
        return result;
    }
}
