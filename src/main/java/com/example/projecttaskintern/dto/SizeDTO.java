package com.example.projecttaskintern.dto;

import lombok.Data;

@Data
public class SizeDTO {
    private Long sizeId;
    private String name;

    public SizeDTO(Long sizeId, String name) {
        this.sizeId = sizeId;
        this.name = name;
    }
}
