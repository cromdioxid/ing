package com.example.demo.exceptions;

public class ProductAlreadyExistsException extends RuntimeException{

    public ProductAlreadyExistsException(long barcode) {
        super("Product alreay exists " + barcode);
    }
}
