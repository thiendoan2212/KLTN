package com.kltn.motelservice.controller;

import com.kltn.motelservice.model.NotificationDTO;
import com.kltn.motelservice.service.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NotificationController {
    @Autowired
    NotificationServiceImpl notificationService;

    @GetMapping("/notification")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public Page<NotificationDTO> getNotificationByEmail(OAuth2Authentication auth, @RequestParam("page") int page, @RequestParam("screen") boolean screen) {
        return notificationService.getNotificationByEmail(auth.getName(), page, screen);
    }

    @PutMapping("/notification/{id}")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public NotificationDTO seenNotification(@PathVariable long id) {
        return notificationService.seenNotification(id);
    }
}
