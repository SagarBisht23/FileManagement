package com.mphasis.security.dto;

public record LoginRequest(
    String login,
    String password
) { }