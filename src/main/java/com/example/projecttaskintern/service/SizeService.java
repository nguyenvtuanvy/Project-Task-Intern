package com.example.projecttaskintern.service;

import com.example.projecttaskintern.dto.SizeDTO;

import java.util.Set;

public interface SizeService {
    Set<SizeDTO> getAllSizeByProductId(Long productId);

    Set<SizeDTO> getAllSize();
}
