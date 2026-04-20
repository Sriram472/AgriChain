package com.cts.agrichainna.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.cts.agrichainna.service.NotificationService;
import com.cts.agrichainna.dto.NotificationDTO;
import com.cts.agrichainna.entity.Notification;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public Notification sendNotification(@RequestBody NotificationDTO dto) {
        return service.sendNotification(dto);
    }

    @GetMapping("/user/{userId}")
    public List<Notification> getUserNotifications(@PathVariable Long userId) {
        return service.getNotificationsByUser(userId);
    }
}