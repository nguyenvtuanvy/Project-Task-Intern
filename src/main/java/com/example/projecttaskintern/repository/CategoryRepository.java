package com.example.projecttaskintern.repository;

import com.example.projecttaskintern.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c")
    Set<Category> GetAllCategory();
}
