package com.example.projecttaskintern.controller;

import com.example.projecttaskintern.dto.ColorDTO;
import com.example.projecttaskintern.dto.ProductDTO;
import com.example.projecttaskintern.dto.SizeDTO;
import com.example.projecttaskintern.response.ProductByCategoryIdToFilterResponse;
import com.example.projecttaskintern.response.ProductByIdResponse;
import com.example.projecttaskintern.service.ColorService;
import com.example.projecttaskintern.service.GalleryImageService;
import com.example.projecttaskintern.service.ProductService;
import com.example.projecttaskintern.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
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
            return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProduct());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetProductById(@PathVariable("id") Long productId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ProductByIdResponse.builder()
                    .productDTO(productService.getProductById(productId))
                    .galleryImageDTOS(galleryImageService.getAllImageByProductId(productId))
                    .colorDTOS(colorService.getAllColorByProductId(productId))
                    .sizeDTOS(sizeService.getAllSizeByProductId(productId))
                    .build());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> GetAllProductByCategoryId(@RequestParam("category-id") Long categoryId){
        try{
            List<ProductByCategoryIdToFilterResponse> products = new ArrayList<>();

            Set<ProductDTO> productDTOS = productService.getAllProductByCategoryId(categoryId);
            productDTOS.forEach(productDTO -> {
                Set<ColorDTO> colorDTOS = colorService.getAllColorByProductId(productDTO.getProductId());
                Set<SizeDTO> sizeDTOS = sizeService.getAllSizeByProductId(productDTO.getProductId());

                ProductByCategoryIdToFilterResponse product = new ProductByCategoryIdToFilterResponse(productDTO, colorDTOS, sizeDTOS);

                products.add(product);
            });
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
