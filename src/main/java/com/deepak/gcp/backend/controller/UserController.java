package com.deepak.gcp.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/dashboard")
    public String userDashboard(){
        return "Welcome to user dashboard";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(){
        return "Welcome to admin dashboard";
    }

}
