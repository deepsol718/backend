package com.deepak.gcp.backend.controller;

import com.deepak.gcp.backend.dto.ContentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hi")
    public ResponseEntity<ContentDto> hi(){
        return ResponseEntity.ok(new ContentDto("Spring boot m sambhal lunga, tu react dekh lena, please"));
    }

    @GetMapping("/bye")
    public ResponseEntity<ContentDto> bye(){
        return ResponseEntity.ok(new ContentDto("bye bye"));
    }

}
