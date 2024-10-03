package com.example.projecttaskintern.service;

import com.example.projecttaskintern.dto.SizeDTO;
import com.example.projecttaskintern.entity.Size;
import com.example.projecttaskintern.repository.SizeRepository;
import com.example.projecttaskintern.utility.SizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SizeServiceImpl implements SizeService{
    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public Set<SizeDTO> getAllSizeByProductId(Long productId) {
        try{
            Set<Size> sizes = sizeRepository.getAllSizeByProductId(productId);

            return sizes.stream()
                    .map(SizeMapper::tosizeDTO)
                    .collect(Collectors.toSet());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public Set<SizeDTO> getAllSize() {
        try{
            Set<Size> sizes = sizeRepository.getAllSize();

            return sizes.stream()
                    .map(SizeMapper::tosizeDTO)
                    .collect(Collectors.toSet());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
