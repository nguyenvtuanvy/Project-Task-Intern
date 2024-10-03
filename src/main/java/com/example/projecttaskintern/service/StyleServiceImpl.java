package com.example.projecttaskintern.service;

import com.example.projecttaskintern.dto.StyleDTO;
import com.example.projecttaskintern.entity.Style;
import com.example.projecttaskintern.repository.StyleRepository;
import com.example.projecttaskintern.utility.SizeMapper;
import com.example.projecttaskintern.utility.StyleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StyleServiceImpl implements StyleService{
    @Autowired
    private StyleRepository styleRepository;

    @Override
    public Set<StyleDTO> getAllStyle() {
        try{
            Set<Style> styles = styleRepository.getAllStyle();

            return styles.stream()
                    .map(StyleMapper::toStyleDTO)
                    .collect(Collectors.toSet());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
