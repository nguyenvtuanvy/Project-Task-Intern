package com.example.projecttaskintern.dto;

import lombok.Data;

@Data
public class StyleDTO {
    private Long styleId;
    private String name;

    public StyleDTO(Long styleId, String name) {
        this.styleId = styleId;
        this.name = name;
    }
}
