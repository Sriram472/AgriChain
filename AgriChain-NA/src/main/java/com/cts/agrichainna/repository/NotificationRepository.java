package com.cts.agrichainna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.cts.agrichainna.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserId(Long userId);
}