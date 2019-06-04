package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.entity.User;
import com.kltn.motelservice.model.NotificationDTO;
import org.springframework.data.domain.Page;

public interface NotificationService {
    void createNotification(User user, Post post);

    Page<NotificationDTO> getNotificationByEmail(String email, int page);

    NotificationDTO seenNotification(Long id);
}
