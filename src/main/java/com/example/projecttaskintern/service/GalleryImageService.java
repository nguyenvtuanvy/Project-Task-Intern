package com.example.projecttaskintern.service;

import com.example.projecttaskintern.dto.GalleryImageDTO;

import java.util.Set;

public interface GalleryImageService {
    Set<GalleryImageDTO> GetAllImageByProductId(Long productId);
}
