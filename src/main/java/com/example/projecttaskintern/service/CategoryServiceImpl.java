package com.example.projecttaskintern.service;

import com.example.projecttaskintern.dto.CategoryDTO;
import com.example.projecttaskintern.entity.Category;
import com.example.projecttaskintern.repository.CategoryRepository;
import com.example.projecttaskintern.utility.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Set<CategoryDTO> getAllCategory() {
        try{
            Set<Category> categories = categoryRepository.getAllCategory();

            return categories.stream()
                    .map(CategoryMapper::toCategoryDTO)
                    .collect(Collectors.toSet());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
