package com.example.projecttaskintern.service;

import com.example.projecttaskintern.dto.GalleryImageDTO;
import com.example.projecttaskintern.entity.GalleryImage;
import com.example.projecttaskintern.entity.Product;
import com.example.projecttaskintern.repository.GalleryImageRepository;
import com.example.projecttaskintern.utility.GalleryImageMapper;
import com.example.projecttaskintern.utility.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GalleryImageServiceImpl implements GalleryImageService{
    @Autowired
    private GalleryImageRepository galleryImageRepository;


    @Override
    public Set<GalleryImageDTO> GetAllImageByProductId(Long productId) {
        try{
            Set<GalleryImage> galleryImages = galleryImageRepository.GetAllImageByProductId(productId);

            return galleryImages.stream()
                    .map(GalleryImageMapper::toGalleryImageDTO)
                    .collect(Collectors.toSet());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
