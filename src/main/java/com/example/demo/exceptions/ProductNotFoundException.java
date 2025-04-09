package com.example.demo.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(long barCode) {
        super("Could not find product with barcode " + barCode);
    }
}
