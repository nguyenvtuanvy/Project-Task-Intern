package com.example.projecttaskintern.response;

import com.example.projecttaskintern.dto.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ProductByCategoryIdToFilterResponse {
    private ProductDTO productDTO;
    private Set<ColorDTO> colorDTOS;
    private Set<SizeDTO> sizeDTOS;

    public ProductByCategoryIdToFilterResponse(ProductDTO productDTO, Set<ColorDTO> colorDTOS, Set<SizeDTO> sizeDTOS) {
        this.productDTO = productDTO;
        this.colorDTOS = colorDTOS;
        this.sizeDTOS = sizeDTOS;
    }
}
