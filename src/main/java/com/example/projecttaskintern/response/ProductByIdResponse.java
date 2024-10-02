package com.example.projecttaskintern.response;

import com.example.projecttaskintern.dto.ColorDTO;
import com.example.projecttaskintern.dto.GalleryImageDTO;
import com.example.projecttaskintern.dto.ProductDTO;
import com.example.projecttaskintern.dto.SizeDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ProductByIdResponse {
    private ProductDTO productDTO;
    private Set<GalleryImageDTO> galleryImageDTOS;
    private Set<ColorDTO> colorDTOS;
    private Set<SizeDTO> sizeDTOS;
}
