package com.example.projecttaskintern.repository;

import com.example.projecttaskintern.dto.ProductDTO;
import com.example.projecttaskintern.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p")
    Set<Product> GetProductAll();

    @Query("select p from Product p where p.productId = :productId")
    Product GetProductById(@Param("productId") Long productId);

    @Query("select p from Product p where p.category.categoryId = :categoryId")
    Set<Product> GetProductAllByCategoryId(@Param("categoryId") Long categoryId);
}
