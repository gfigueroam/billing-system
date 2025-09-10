package com.example.billing.model;

import com.example.billing.repository.entities.Role;
import lombok.Data;

@Data
public class RegisterUserDto {
    private String email;
    private String password;
    private String fullName;
    private Role role;
}
