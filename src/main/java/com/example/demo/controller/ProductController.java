package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductsService productsService;

    @Autowired
    ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productsService.getProducts();
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product newProduct) {
        return productsService.addNewProduct(newProduct);
    }

    @PatchMapping("/product")
    public Product editProduct(@RequestBody Product newProductInfo) {
        return productsService.editProduct(newProductInfo);
    }
}
