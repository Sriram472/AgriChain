package com.cts.agrichain.agrichainiam_.service;

import com.cts.agrichain.agrichainiam_.dto.LoginRequest;
import com.cts.agrichain.agrichainiam_.entity.User;
import com.cts.agrichain.agrichainiam_.repository.UserRepository;
import com.cts.agrichain.agrichainiam_.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuditLogService auditLogService;

    public AuthService(UserRepository repo, PasswordEncoder encoder, JwtUtil jwtUtil, AuditLogService auditLogService) {
        this.userRepository = repo;
        this.passwordEncoder = encoder;
        this.jwtUtil = jwtUtil;
        this.auditLogService = auditLogService;
    }

    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        auditLogService.log(user.getUserID(), "LOGIN", "auth");
        return jwtUtil.generateToken(user.getEmail(), user.getRole());
    }
}
