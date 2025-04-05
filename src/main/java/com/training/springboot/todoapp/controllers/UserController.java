package com.training.springboot.todoapp.controllers;

import com.training.springboot.todoapp.models.LoginRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@Tag(name = "User Services", description = "User Services")
@RequestMapping("/user")
@Slf4j
public class UserController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest login) {
        String pwd = "";
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(login.getPassword());
            pwd = new String(decodedBytes);
        } catch (Exception ignored) {
        }

        String token = new String(Base64.getEncoder().encode((login.getUsername() + ":" + pwd).getBytes()));

        return login.getUsername().equals("admin")
                && "admin".equals(pwd)
                ? new ResponseEntity<>(token, HttpStatus.OK)
                : new ResponseEntity<>("Invalid Login Attempt", HttpStatus.UNAUTHORIZED);
    }

}
