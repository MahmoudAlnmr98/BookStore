package com.bookstore.catalogservice.web.controllers;


import com.bookstore.catalogservice.domain.PagedResult;
import com.bookstore.catalogservice.domain.Product;
import com.bookstore.catalogservice.domain.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1")int pageNo)
    {
        return productService.getProducts(pageNo);
    }

    @GetMapping("/{code}")
    Optional<Product> getProductByCode(@PathVariable String code)
    {
        return productService.getProductbyCode(code);
    }


}
