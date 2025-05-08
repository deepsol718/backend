package com.deepak.gcp.backend.controller;

import com.deepak.gcp.backend.dto.ContentDto;
import com.deepak.gcp.backend.entity.User;
import com.deepak.gcp.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hi")
    public ResponseEntity<ContentDto> hi(){
        return ResponseEntity.ok(new ContentDto("Spring boot m sambhal lunga, tu react dekh lena, please"));
    }

    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserById(@RequestParam Long id){
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customfilter/hi")
    public String sendHi(){
        return "Hi";
    }


    @GetMapping("/bye")
    public ResponseEntity<ContentDto> bye(){
        return ResponseEntity.ok(new ContentDto("bye bye"));
    }

}
