package com.mphasis.security.controller;

import com.mphasis.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
