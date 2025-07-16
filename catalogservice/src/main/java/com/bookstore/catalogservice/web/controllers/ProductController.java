package com.bookstore.catalogservice.web.controllers;


import com.bookstore.catalogservice.domain.ProductEntity;
import com.bookstore.catalogservice.domain.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
class ProductController
{
    private final ProductService productService;

    ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping
    Page<ProductEntity> getProducts(@RequestParam(name = "page", defaultValue = "1")int pageNo)
    {
        return productService.getProducts(pageNo);
    }



}
