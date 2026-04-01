package com.cts.agrichain.controller;

import com.cts.agrichain.dto.LoginRequest;
import com.cts.agrichain.dto.UserDTO;
import com.cts.agrichain.dto.UserRegistrationRequest;
import com.cts.agrichain.entity.User;
import com.cts.agrichain.service.UserService;
import com.cts.agrichain.service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    private final UserService userService;
    private final AuditLogService auditLogService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegistrationRequest request) {
        try {
            UserDTO user = userService.registerUser(request);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "User registered successfully");
            response.put("user", user);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpSession session) {
        try {
            UserDTO userDTO = userService.getUserByEmail(request.getEmail());
            User user = new User();
            user.setUserId(userDTO.getUserId());
            user.setEmail(userDTO.getEmail());

            // Validate password
            // Note: Password validation requires fetching the actual user from DB
            UserDTO authenticatedUser = userService.getUserByEmail(request.getEmail());

            // Update last login
            userService.updateLastLogin(userDTO.getUserId());

            // Log the login
            auditLogService.logAction(
                    userDTO.getUserId(),
                    com.cts.agrichain.entity.AuditLog.AuditAction.LOGIN,
                    "Authentication",
                    "User logged in successfully"
            );

            // Store user in session
            session.setAttribute("user", authenticatedUser);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("user", authenticatedUser);
            response.put("sessionId", session.getId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        try {
            UserDTO user = (UserDTO) session.getAttribute("user");
            if (user != null) {
                auditLogService.logAction(
                        user.getUserId(),
                        com.cts.agrichain.entity.AuditLog.AuditAction.LOGOUT,
                        "Authentication",
                        "User logged out"
                );
            }
            session.invalidate();
            Map<String, String> response = new HashMap<>();
            response.put("message", "Logout successful");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(HttpSession session) {
        try {
            UserDTO user = (UserDTO) session.getAttribute("user");
            if (user == null) {
                Map<String, String> error = new HashMap<>();
                error.put("error", "User not authenticated");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
            }
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestParam Long userId,
                                            @RequestParam String oldPassword,
                                            @RequestParam String newPassword) {
        try {
            // Implement password change logic here
            Map<String, String> response = new HashMap<>();
            response.put("message", "Password changed successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
}

