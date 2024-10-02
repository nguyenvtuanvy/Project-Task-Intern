package com.example.projecttaskintern.utility;

import com.example.projecttaskintern.dto.SizeDTO;
import com.example.projecttaskintern.dto.StyleDTO;
import com.example.projecttaskintern.entity.Size;
import com.example.projecttaskintern.entity.Style;

public class StyleMapper {
    public static StyleDTO toStyleDTO(Style style){
        return new StyleDTO(style.getStyleId(), style.getName());
    }
}
