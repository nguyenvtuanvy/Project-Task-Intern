package com.example.projecttaskintern.controller;

import com.example.projecttaskintern.dto.ColorDTO;
import com.example.projecttaskintern.dto.ProductDTO;
import com.example.projecttaskintern.dto.SizeDTO;
import com.example.projecttaskintern.response.ProductByCategoryIdToFilter;
import com.example.projecttaskintern.response.ProductByIdResponse;
import com.example.projecttaskintern.service.ColorService;
import com.example.projecttaskintern.service.GalleryImageService;
import com.example.projecttaskintern.service.ProductService;
import com.example.projecttaskintern.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private GalleryImageService galleryImageService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private SizeService sizeService;

    @GetMapping("/all")
    public ResponseEntity<?> GetAllProduct(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productService.GetAllProduct());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetProductById(@PathVariable("id") Long productId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ProductByIdResponse.builder()
                    .productDTO(productService.GetProductById(productId))
                    .galleryImageDTOS(galleryImageService.GetAllImageByProductId(productId))
                    .colorDTOS(colorService.GetAllColorByProductId(productId))
                    .sizeDTOS(sizeService.GetAllSizeByProductId(productId))
                    .build());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> GetAllProductByCategoryId(@PathVariable("id") Long categoryId){
        try{
            List<ProductByCategoryIdToFilter> products = new ArrayList<>();

            Set<ProductDTO> productDTOS = productService.GetAllProductByCategoryId(categoryId);
            productDTOS.forEach(productDTO -> {
                Set<ColorDTO> colorDTOS = colorService.GetAllColorByProductId(productDTO.getProductId());
                Set<SizeDTO> sizeDTOS = sizeService.GetAllSizeByProductId(productDTO.getProductId());

                ProductByCategoryIdToFilter product = new ProductByCategoryIdToFilter(productDTO, colorDTOS, sizeDTOS);

                products.add(product);
            });
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
