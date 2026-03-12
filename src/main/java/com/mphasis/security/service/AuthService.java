package com.mphasis.security.service;

import com.mphasis.security.model.User;
import com.mphasis.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public void register(RegisterRequest request){
        User user = new User();

        user.setUsername((request.getUsername()));

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        repository.save(user);
    }

    public String login(){
        return " ";
    }
}
