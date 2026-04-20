package com.cts.agrichaincam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to AgriChain-CAM Application");
        response.put("status", "Application is running successfully");
        response.put("version", "1.0.0");
        response.put("available_endpoints", new String[]{
            "/api/audits - Get all audits (GET) or create new audit (POST)",
            "/api/compliance - Get all compliance records (GET) or create new record (POST)",
            "/h2-console - H2 Database Console (GET)"
        });
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("message", "Application is healthy");
        return ResponseEntity.ok(response);
    }
}

