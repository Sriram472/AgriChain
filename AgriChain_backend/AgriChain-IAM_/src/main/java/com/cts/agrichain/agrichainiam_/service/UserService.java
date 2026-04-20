package com.cts.agrichain.agrichainiam_.service;

import com.cts.agrichain.agrichainiam_.dto.UserRegistrationRequest;
import com.cts.agrichain.agrichainiam_.entity.User;
import com.cts.agrichain.agrichainiam_.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuditLogService auditLogService;

    public UserService(UserRepository repo, PasswordEncoder encoder, AuditLogService auditLogService) {
        this.userRepository = repo;
        this.passwordEncoder = encoder;
        this.auditLogService = auditLogService;
    }

    public User register(UserRegistrationRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setStatus("ACTIVE");
        User saved = userRepository.save(user);
        auditLogService.log(saved.getUserID(), "REGISTER", "users");
        return saved;
    }
}
