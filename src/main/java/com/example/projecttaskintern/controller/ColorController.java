package com.example.projecttaskintern.controller;

import com.example.projecttaskintern.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/color")
public class ColorController {
    @Autowired
    private ColorService colorService;

    @GetMapping("/all")
    public ResponseEntity<?> GetAllColor(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(colorService.getAllColor());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
