package com.example.demo.controller;

import com.example.demo.exceptions.ProductAlreadyExistsException;
import com.example.demo.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductNotFoundAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundHandler(ProductNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String productAlreadyExistsHandler(ProductAlreadyExistsException ex) {
        return ex.getMessage();
    }
}
