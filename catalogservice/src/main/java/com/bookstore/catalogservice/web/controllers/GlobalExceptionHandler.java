package com.bookstore.catalogservice.web.controllers;

import com.bookstore.catalogservice.domain.exceptions.PageNotFoundException;
import com.bookstore.catalogservice.domain.exceptions.ProductNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(PageNotFoundException.class)
    public ResponseEntity<Map<String,String>> handlePageNotFound(PageNotFoundException ex)
    {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("error","page not found", "message",ex.getMessage()));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleProductNotFound(ProductNotFoundException ex)
    {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Product Not Found","Message",ex.getMessage()));
    }
}
