package com.mphasis.security.service;

import com.mphasis.security.controller.UserController;
import com.mphasis.security.dao.UserRepository;
import com.mphasis.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository repo;

    public List<User> getAllUser(){
        return repo.findAll();
    }
}
