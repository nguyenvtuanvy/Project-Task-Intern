package com.example.projecttaskintern.utility;

import com.example.projecttaskintern.dto.ColorDTO;
import com.example.projecttaskintern.entity.Color;

public class ColorMapper {
    public static ColorDTO tocolorDTO(Color color){
        return new ColorDTO(color.getColorId(), color.getColorCode());
    }
}
