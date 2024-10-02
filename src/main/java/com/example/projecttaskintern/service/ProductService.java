package com.example.projecttaskintern.service;

import com.example.projecttaskintern.dto.ProductDTO;

import java.util.Set;

public interface ProductService {
    Set<ProductDTO> GetAllProduct();

    Set<ProductDTO> GetAllProductByCategoryId(Long categoryId);

    ProductDTO GetProductById(Long productId);
}
