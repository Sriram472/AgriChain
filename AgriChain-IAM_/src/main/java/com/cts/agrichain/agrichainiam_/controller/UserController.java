package com.cts.agrichain.agrichainiam_.controller;

import com.cts.agrichain.agrichainiam_.dto.UserRegistrationRequest;
import com.cts.agrichain.agrichainiam_.entity.User;
import com.cts.agrichain.agrichainiam_.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody UserRegistrationRequest request) {
        return userService.register(request);
    }
}
