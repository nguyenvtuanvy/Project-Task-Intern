package com.example.projecttaskintern.service;

import com.example.projecttaskintern.dto.ColorDTO;
import com.example.projecttaskintern.entity.Color;
import com.example.projecttaskintern.entity.GalleryImage;
import com.example.projecttaskintern.repository.ColorRepository;
import com.example.projecttaskintern.utility.ColorMapper;
import com.example.projecttaskintern.utility.GalleryImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ColorServiceImpl implements ColorService{
    @Autowired
    private ColorRepository colorRepository;

    @Override
    public Set<ColorDTO> GetAllColorByProductId(Long productId) {
        try{
            Set<Color> colors = colorRepository.GetAllColorByProductId(productId);

            return colors.stream()
                    .map(ColorMapper::tocolorDTO)
                    .collect(Collectors.toSet());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public Set<ColorDTO> GetAllColor() {
        try{
            Set<Color> colors = colorRepository.GetAllColor();

            return colors.stream()
                    .map(ColorMapper::tocolorDTO)
                    .collect(Collectors.toSet());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
