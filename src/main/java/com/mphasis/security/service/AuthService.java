package com.mphasis.security.service;

import com.mphasis.security.dto.LoginRequest;
import com.mphasis.security.dto.RegisterRequest;
import com.mphasis.security.model.User;
import com.mphasis.security.repository.UserRepository;
import com.mphasis.security.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        repository.save(user);
    }

    public String login(LoginRequest request){

        User user = repository
                .findByUsernameOrEmail(request.getLogin(), request.getLogin())
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));

        if(!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )){
            throw new RuntimeException("Invalid password");
        }
        return jwtUtil.generateToken(user.getUsername());
    }
}
