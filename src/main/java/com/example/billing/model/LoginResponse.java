package com.example.billing.model;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private Long expiresIn;
}
