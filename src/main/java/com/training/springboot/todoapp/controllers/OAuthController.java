package com.training.springboot.todoapp.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "OAuth Service", description = "All services related to OAuth management")
@RequestMapping("/auth")
@RestController
public class OAuthController {

    @GetMapping("/")
    public String authentication(@AuthenticationPrincipal OAuth2User user) {
        return ((DefaultOidcUser) user).getIdToken().getTokenValue();
    }

    @GetMapping("/me")
    public Map<String, Object> userDetails(@AuthenticationPrincipal OAuth2User user) {

        Map<String, Object> map = new HashMap<>(user.getAttributes());
        map.put("token", ((DefaultOidcUser) user).getIdToken().getTokenValue());

        return map;
    }
}
