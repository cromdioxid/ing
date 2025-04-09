package com.example.demo.controller;

import com.example.demo.repository.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository repo;

    ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/products")
    public String getAllProducts() {
        return "hello first endpoint";
    }
}
