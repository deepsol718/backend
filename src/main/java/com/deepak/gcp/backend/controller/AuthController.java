package com.deepak.gcp.backend.controller;

import com.deepak.gcp.backend.dto.AuthRequest;
import com.deepak.gcp.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest){
        try{
            Authentication authentication = authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

            if(authentication.isAuthenticated()){
                String jwtToken =  jwtUtil.generateToken(authRequest.getUsername());
                System.out.println("jwt token: "+jwtToken);
                return jwtToken;
            }
            else{
                throw new RuntimeException("Invalid login");
            }
        }
        catch (AuthenticationException e){
            throw new RuntimeException("Invalid login");
        }
    }


}
