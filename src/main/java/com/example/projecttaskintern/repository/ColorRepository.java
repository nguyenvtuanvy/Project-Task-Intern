package com.example.projecttaskintern.repository;

import com.example.projecttaskintern.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ColorRepository extends JpaRepository<Color, Long> {
    @Query("select c from Color c join c.products p where p.productId = :productId")
    Set<Color> GetAllColorByProductId(@Param("productId") Long productId);

    @Query("select c from Color c")
    Set<Color> GetAllColor();
}
