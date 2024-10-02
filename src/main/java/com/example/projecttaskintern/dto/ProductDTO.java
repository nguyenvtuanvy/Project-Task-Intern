package com.example.projecttaskintern.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long productId;
    private String description;
    private String image;
    private String name;
    private BigDecimal price;
    private BigDecimal priceDiscount;
    private Float rating_average;
    private Long style_id;

    public ProductDTO(Long productId, String description, String image, String name, BigDecimal price, BigDecimal priceDiscount, Float rating_average, Long style_id) {
        this.productId = productId;
        this.description = description;
        this.image = image;
        this.name = name;
        this.price = price;
        this.priceDiscount = priceDiscount;
        this.rating_average = rating_average;
        this.style_id = style_id;
    }
}
