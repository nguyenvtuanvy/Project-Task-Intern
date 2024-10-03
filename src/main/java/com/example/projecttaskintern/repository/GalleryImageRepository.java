package com.example.projecttaskintern.repository;

import com.example.projecttaskintern.entity.GalleryImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface GalleryImageRepository extends JpaRepository<GalleryImage, Long> {
    @Query("select gi from GalleryImage gi where gi.product.productId = :productId")
    Set<GalleryImage> getAllImageByProductId(@Param("productId") Long productId);
}
