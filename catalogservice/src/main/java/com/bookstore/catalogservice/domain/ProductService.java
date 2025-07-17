package com.bookstore.catalogservice.domain;


import com.bookstore.catalogservice.domain.exceptions.PageNotFoundException;
import com.bookstore.catalogservice.domain.exceptions.ProductNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@Transactional
public class ProductService
{
    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public PagedResult<Product> getProducts(int pageNo)
    {
        pageNo = pageNo <=1 ? 0 : pageNo -1 ;
        Pageable pageable = PageRequest.of(pageNo, 10 , Sort.by("name").ascending());
        Page<Product> pageResult =  productRepository.findAll(pageable).map(ProductMapper::toProduct);
        if(pageNo >= pageResult.getTotalPages() && pageResult.getTotalPages() != 0)
        {
            throw PageNotFoundException.forPage(pageNo);
        }
        return new PagedResult<>
            (
                pageResult.getContent(),
                pageResult.getTotalElements(),
                pageResult.getNumber(),
                pageResult.getTotalPages(),
                pageResult.isFirst(),
                pageResult.isLast(),
                pageResult.hasNext(),
                pageResult.hasPrevious()
            );
    }

    public Optional<Product> getProductByCode(String code)
    {
        return Optional.of(productRepository.findByCode(code).map(ProductMapper::toProduct)
                .orElseThrow(() -> ProductNotFoundException.forCode(code)));
    }
}
