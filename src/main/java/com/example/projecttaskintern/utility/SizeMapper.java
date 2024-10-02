package com.example.projecttaskintern.utility;

import com.example.projecttaskintern.dto.SizeDTO;
import com.example.projecttaskintern.entity.Size;

public class SizeMapper {
    public static SizeDTO tosizeDTO(Size size){
        return new SizeDTO(size.getSizeId(), size.getName());
    }
}
