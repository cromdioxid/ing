package com.example.demo.service;

import com.example.demo.controller.ProductController;
import com.example.demo.exceptions.ProductAlreadyExistsException;
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
        List<Product> result = repo.findByBarCode(String.valueOf(newProduct.getBarCode()));
        if (result.isEmpty()) {
            Product product = repo.save(newProduct);
            log.info("Successfully added product: " + result.toString());
            return product;
        }

        log.error("Product " + newProduct.getBarCode() + " already exists");
        throw new ProductAlreadyExistsException(newProduct.getBarCode());
    }

    public Product editProduct(Product newProduct) {
        List<Product> result = repo.findByBarCode(String.valueOf(newProduct.getBarCode()));
        if (!result.isEmpty()) {
            Product existingProduct = result.get(0);
            existingProduct.setName(newProduct.getName());
            existingProduct.setPrice(newProduct.getPrice());
            repo.save(existingProduct);
            log.info("Product with barcode nr: " + existingProduct.getBarCode() + " saved successfully");
            return newProduct;
        }

        log.error("Product with barcode nr " + newProduct.getBarCode() + "not found in DB");
        throw new ProductNotFoundException(newProduct.getBarCode());
    }

    public Product getProduct(long barCode) {
        List<Product> result = repo.findByBarCode(String.valueOf(barCode));
        if (!result.isEmpty()) {
            log.info("Product with barcode nr " + barCode + "retrieved from DB");
            return result.get(0);
        }

        log.error("Product with barcode nr" + barCode + "not found in DB");
        throw new ProductNotFoundException(barCode);
    }

    public Product changePrice(long barCode, long price) {
        List<Product> result = repo.findByBarCode(String.valueOf(barCode));
        if(!result.isEmpty()) {
            Product oldProduct = result.get(0);
            oldProduct.setPrice(price);
            repo.save(oldProduct);
            log.info("Product with barcode nr " + barCode + " has a new price!");
            return oldProduct;
        }

        log.error("Product with barcode " + barCode + " is not in DB");
        throw new ProductNotFoundException(barCode);
    }

    public Product deleteProduct(long barcode) {
        List<Product> productList = repo.findByBarCode(String.valueOf(barcode));
        if (!productList.isEmpty()) {
            Product product = productList.get(0);
            repo.delete(product);
            log.info("Product with barcode nr " + barcode + " was deleted");
            return product;
        }

        log.error("Product with barcode no " + barcode + " was not found in DB");
        throw new ProductNotFoundException(barcode);
    }
}
