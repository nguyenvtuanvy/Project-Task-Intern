package com.example.projecttaskintern.dto;

import lombok.Data;

@Data
public class ColorDTO {
    private Long colorId;
    private String colorCode;

    public ColorDTO(Long colorId, String colorCode) {
        this.colorId = colorId;
        this.colorCode = colorCode;
    }
}
