package com.example.digitom.service.account;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
