package com.example.projecttaskintern.service;

import com.example.projecttaskintern.dto.ColorDTO;
import com.example.projecttaskintern.dto.GalleryImageDTO;
import com.example.projecttaskintern.entity.Color;

import java.util.Set;

public interface ColorService {
    Set<ColorDTO> GetAllColorByProductId(Long productId);

    Set<ColorDTO> GetAllColor();
}
