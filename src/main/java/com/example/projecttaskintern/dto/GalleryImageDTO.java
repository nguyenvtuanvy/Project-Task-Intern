package com.example.projecttaskintern.dto;

import lombok.Data;

@Data
public class GalleryImageDTO {
    private Long galleryImageId;
    private String image;

    public GalleryImageDTO(Long galleryImageId, String image) {
        this.galleryImageId = galleryImageId;
        this.image = image;
    }
}
