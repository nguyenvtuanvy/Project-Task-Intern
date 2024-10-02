package com.example.projecttaskintern.controller;

import com.example.projecttaskintern.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/size")
public class SizeController {
    @Autowired
    private SizeService sizeService;

    @GetMapping("/all")
    public ResponseEntity<?> GetAllSize(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(sizeService.GetAllSize());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
