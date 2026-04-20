package com.cts.agrichainna.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import com.cts.agrichainna.repository.NotificationRepository;
import com.cts.agrichainna.dto.NotificationDTO;
import com.cts.agrichainna.entity.Notification;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public Notification sendNotification(NotificationDTO dto) {

        Notification notification = new Notification();
        notification.setUserId(dto.getUserId());
        notification.setMessage(dto.getMessage());
        notification.setCategory(dto.getCategory());
        notification.setStatus("SENT");
        notification.setCreatedDate(LocalDateTime.now());

        return repository.save(notification);
    }

    public List<Notification> getNotificationsByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}
