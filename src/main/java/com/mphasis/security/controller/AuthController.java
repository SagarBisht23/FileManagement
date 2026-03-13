package com.mphasis.security.controller;

import com.mphasis.security.dto.AuthResponse;
import com.mphasis.security.dto.LoginRequest;
import com.mphasis.security.dto.RegisterRequest;
import com.mphasis.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request)
    {
        authService.register(request);
        return "User Registered Successfully";
    }


    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request)
    {
        String token = authService.login(request);

        return new AuthResponse(token);
    }
}
