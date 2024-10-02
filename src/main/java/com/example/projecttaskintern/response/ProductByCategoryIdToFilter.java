package com.example.projecttaskintern.response;

import com.example.projecttaskintern.dto.*;
import com.example.projecttaskintern.entity.Style;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ProductByCategoryIdToFilter {
    private ProductDTO productDTO;
    private Set<ColorDTO> colorDTOS;
    private Set<SizeDTO> sizeDTOS;

    public ProductByCategoryIdToFilter(ProductDTO productDTO, Set<ColorDTO> colorDTOS, Set<SizeDTO> sizeDTOS) {
        this.productDTO = productDTO;
        this.colorDTOS = colorDTOS;
        this.sizeDTOS = sizeDTOS;
    }
}
