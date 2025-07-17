package com.bookstore.catalogservice.web.controllers;

import com.bookstore.catalogservice.domain.exceptions.PageNotFoundException;
import com.bookstore.catalogservice.domain.exceptions.ProductNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    private static final String SERVICE_NAME = "catalog-service";
    private static final URI NOT_FOUND = URI.create("https://api.bookstore.com/errors/not-found");
    @ExceptionHandler({PageNotFoundException.class, ProductNotFoundException.class})
    public ProblemDetail handleNotFound(RuntimeException ex)
    {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Not Found");
        problemDetail.setType(NOT_FOUND);
        problemDetail.setProperty("service", SERVICE_NAME);
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

}
