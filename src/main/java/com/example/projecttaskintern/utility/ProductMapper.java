package com.example.projecttaskintern.utility;

import com.example.projecttaskintern.dto.ProductDTO;
import com.example.projecttaskintern.entity.Product;
import com.example.projecttaskintern.entity.Rating;

public class ProductMapper {
    public static ProductDTO toProductDTO(Product product) {
        Float averageRating = product.getRatings().isEmpty() ?
                0.0f :
                (float) product.getRatings().stream()
                        .mapToDouble(Rating::getRating)
                        .average()
                        .orElse(0.0);

        return new ProductDTO(
                product.getProductId(),
                product.getDescription(),
                product.getImage(),
                product.getName(),
                product.getPrice(),
                product.getPriceDiscount(),
                averageRating,
                product.getStyle().getStyleId()
        );
    }
}
