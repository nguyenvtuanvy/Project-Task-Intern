package com.example.projecttaskintern.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private Long categoryId;
    private String name;

    public CategoryDTO(Long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }
}
