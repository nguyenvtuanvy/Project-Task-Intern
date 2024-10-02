package com.example.projecttaskintern.repository;

import com.example.projecttaskintern.entity.Size;
import com.example.projecttaskintern.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface StyleRepository extends JpaRepository<Style, Long> {
    @Query("select st from Style st")
    Set<Style> GetAllStyle();
}
