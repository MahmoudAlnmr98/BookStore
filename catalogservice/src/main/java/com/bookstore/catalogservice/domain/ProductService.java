package com.bookstore.catalogservice.domain;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class ProductService
{
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public Page<ProductEntity> getProducts(int pageNo)
    {
        pageNo = pageNo <=1 ? 0 : pageNo -1 ;
        Pageable pageable = PageRequest.of(pageNo, 10 , Sort.by("name").ascending());
        return productRepository.findAll(pageable);
    }
}
