package com.cts.agrichain.agrichainiam_.controller;

import com.cts.agrichain.agrichainiam_.dto.LoginRequest;
import com.cts.agrichain.agrichainiam_.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService service) {
        this.authService = service;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        String token = authService.login(request);
        return Map.of("token", token);
    }
}
