package com.example.projecttaskintern.service;

import com.example.projecttaskintern.dto.ProductDTO;

import java.util.Set;

public interface ProductService {
    Set<ProductDTO> getAllProduct();

    Set<ProductDTO> getAllProductByCategoryId(Long categoryId);

    ProductDTO getProductById(Long productId);
}
