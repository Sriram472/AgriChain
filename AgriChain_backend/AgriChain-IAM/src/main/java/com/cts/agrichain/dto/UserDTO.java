package com.cts.agrichain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.cts.agrichain.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private User.UserRole role;
    private User.UserStatus status;
    private String createdAt;
    private String lastLogin;
}

