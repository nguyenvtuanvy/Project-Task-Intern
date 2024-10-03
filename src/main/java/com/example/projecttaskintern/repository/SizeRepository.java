package com.example.projecttaskintern.repository;

import com.example.projecttaskintern.entity.GalleryImage;
import com.example.projecttaskintern.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface SizeRepository extends JpaRepository<Size, Long> {
    @Query("select s from Size s join s.products p where p.productId = :productId")
    Set<Size> getAllSizeByProductId(@Param("productId") Long productId);

    @Query("select s from Size s")
    Set<Size> getAllSize();
}
