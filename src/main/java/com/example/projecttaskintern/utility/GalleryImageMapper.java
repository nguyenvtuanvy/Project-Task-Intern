package com.example.projecttaskintern.utility;

import com.example.projecttaskintern.dto.GalleryImageDTO;
import com.example.projecttaskintern.entity.GalleryImage;

public class GalleryImageMapper {
    public static GalleryImageDTO toGalleryImageDTO(GalleryImage galleryImage){
        return new GalleryImageDTO(galleryImage.getId(), galleryImage.getImage());
    }
}
