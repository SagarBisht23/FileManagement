package com.mphasis.security.dto;

public record RegisterRequest(
        String username,
        String email,
        String password
) { }