package com.example.projecttaskintern.controller;

import com.example.projecttaskintern.service.SizeService;
import com.example.projecttaskintern.service.StyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/style")
public class StyleController {
    @Autowired
    private StyleService styleService;

    @GetMapping("/all")
    public ResponseEntity<?> GetAllStyle(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(styleService.getAllStyle());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
