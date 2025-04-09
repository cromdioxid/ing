package com.example.demo.service;

import com.example.demo.controller.ProductController;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private static final Logger log = LoggerFactory.getLogger(ProductsService.class);
    private final ProductRepository repo;

    public ProductsService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getProducts() {
        List<Product> products = repo.findAll();
        log.info("All available products:" + products.toString());
        return products;
    }

    public Product addNewProduct(Product newProduct) {
        Product result = repo.save(newProduct);
        log.info("Successfully added product: " + result.toString());
        return result;
    }

    public Product editProduct(Product newProduct) {
        List<Product> result = repo.findByBarCode(String.valueOf(newProduct.getBarCode()));
        if (!result.isEmpty()) {
            Product existingProduct = result.get(0);
            existingProduct.setName(newProduct.getName());
            existingProduct.setPrice(newProduct.getPrice());
            repo.save(existingProduct);
            return newProduct;
        }

        throw new ProductNotFoundException(newProduct.getBarCode());
    }
}
