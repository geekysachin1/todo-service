package com.training.springboot.todoapp.models;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
