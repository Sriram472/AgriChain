package com.cts.agrichain.service;

import com.cts.agrichain.dto.UserDTO;
import com.cts.agrichain.dto.UserRegistrationRequest;
import com.cts.agrichain.entity.User;
import com.cts.agrichain.entity.AuditLog;
import com.cts.agrichain.repository.UserRepository;
import com.cts.agrichain.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuditLogRepository auditLogRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDTO registerUser(UserRegistrationRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setStatus(User.UserStatus.ACTIVE);

        User savedUser = userRepository.save(user);

        // Log the registration
        logAction(
                savedUser.getUserId(),
                AuditLog.AuditAction.CREATE,
                "User",
                "User registered with role: " + request.getRole()
        );

        return convertToDTO(savedUser);
    }

    public UserDTO getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDTO getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<UserDTO> getUsersByRole(User.UserRole role) {
        return userRepository.findByRole(role).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<UserDTO> getUsersByStatus(User.UserStatus status) {
        return userRepository.findByStatus(status).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserDTO updateUser(Long userId, UserRegistrationRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setRole(request.getRole());

        User updatedUser = userRepository.save(user);

        logAction(
                userId,
                AuditLog.AuditAction.UPDATE,
                "User",
                "User profile updated"
        );

        return convertToDTO(updatedUser);
    }

    @Transactional
    public void updateUserStatus(Long userId, User.UserStatus status) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setStatus(status);
        userRepository.save(user);

        logAction(
                userId,
                AuditLog.AuditAction.UPDATE,
                "User",
                "User status changed to: " + status
        );
    }

    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

        logAction(
                userId,
                AuditLog.AuditAction.DELETE,
                "User",
                "User account deleted"
        );
    }

    @Transactional
    public void updateLastLogin(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);
    }

    public boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    private void logAction(Long userId, AuditLog.AuditAction action, String resource, String description) {
        AuditLog auditLog = new AuditLog();
        auditLog.setUserId(userId);
        auditLog.setAuditAction(action);
        auditLog.setAction(action.toString());
        auditLog.setResource(resource);
        auditLog.setDescription(description);
        auditLog.setStatus("SUCCESS");
        auditLogRepository.save(auditLog);
    }

    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        dto.setStatus(user.getStatus());
        dto.setCreatedAt(user.getCreatedAt() != null ? user.getCreatedAt().toString() : null);
        dto.setLastLogin(user.getLastLogin() != null ? user.getLastLogin().toString() : null);
        return dto;
    }
}

