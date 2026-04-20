package com.cts.agrichain.agrichainiam_.dto;

import lombok.Data;

@Data
public class UserRegistrationRequest {
    private String name;
    private String email;
    private String phone;
    private String password;
    private String role;
}
