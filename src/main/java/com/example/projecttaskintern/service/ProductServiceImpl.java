package com.example.projecttaskintern.service;

import com.example.projecttaskintern.dto.ProductDTO;
import com.example.projecttaskintern.entity.Product;
import com.example.projecttaskintern.repository.ProductRepository;
import com.example.projecttaskintern.utility.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Set<ProductDTO> GetAllProduct() {
        try{
            Set<Product> products = productRepository.GetProductAll();

            return products.stream()
                    .map(ProductMapper::toProductDTO)
                    .collect(Collectors.toSet());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Set<ProductDTO> GetAllProductByCategoryId(Long categoryId) {
        try{
            Set<Product> products = productRepository.GetProductAllByCategoryId(categoryId);

            return products.stream()
                    .map(ProductMapper::toProductDTO)
                    .collect(Collectors.toSet());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public ProductDTO GetProductById(Long productId) {
        try{
            Product product = productRepository.GetProductById(productId);

            return ProductMapper.toProductDTO((product));
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
