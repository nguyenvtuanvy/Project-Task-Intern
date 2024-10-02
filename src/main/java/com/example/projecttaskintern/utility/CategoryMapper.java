package com.example.projecttaskintern.utility;

import com.example.projecttaskintern.dto.CategoryDTO;
import com.example.projecttaskintern.dto.ColorDTO;
import com.example.projecttaskintern.entity.Category;
import com.example.projecttaskintern.entity.Color;

public class CategoryMapper {
    public static CategoryDTO toCategoryDTO(Category category){
        return new CategoryDTO(category.getCategoryId(), category.getName());
    }
}
