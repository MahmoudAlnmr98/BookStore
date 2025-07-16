package com.bookstore.catalogservice.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class ProductEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_generator")
    @SequenceGenerator(name = "product_id_generator", sequenceName = "product_id_seq")
    private int id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "product code is required")
    private String code;

    @Column(nullable = false)
    @NotBlank(message = "product name is required")
    private String name;

    private String description;

    private String image_url;

    @Column(nullable = false)
    @DecimalMin("0.1")
    @NotNull(message = "product price is required")
    private BigDecimal price;


    public ProductEntity() {}

    public ProductEntity(BigDecimal price, String imageURL, String description, String name, String code, int id) {
        this.price = price;
        this.image_url = imageURL;
        this.description = description;
        this.name = name;
        this.code = code;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage_url() {
        return image_url;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
