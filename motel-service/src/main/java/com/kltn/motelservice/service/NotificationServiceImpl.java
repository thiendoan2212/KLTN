package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.Notification;
import com.kltn.motelservice.entity.Post;
import com.kltn.motelservice.entity.User;
import com.kltn.motelservice.exception.NotificationException;
import com.kltn.motelservice.exception.UserException;
import com.kltn.motelservice.model.NotificationDTO;
import com.kltn.motelservice.model.PostDTO;
import com.kltn.motelservice.repository.NotificationRepository;
import com.kltn.motelservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createNotification(User user, Post post) {
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setPost(post);
        notification.setSeen(false);
        notificationRepository.save(notification);
    }

    @Override
    public Page<NotificationDTO> getNotificationByEmail(String email, int page) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            Page<Notification> notificationPage = notificationRepository.findAllByUser(user.get(), PageRequest.of(page, 10));
            return notificationPage.map(this::notificationToNotificationDTO);
        } else {
            throw new UserException("Không tìm thấy user " + email);
        }
    }

    @Override
    public NotificationDTO seenNotification(Long id) {
        Optional<Notification> notification = notificationRepository.findById(id);
        if (notification.isPresent()) {
            notification.get().setSeen(true);

            return notificationToNotificationDTO(notification.get());
        } else {
            throw new NotificationException("Không tìm thấy notification id " + id);
        }
    }

    public NotificationDTO notificationToNotificationDTO(Notification notification) {
        NotificationDTO notificationDTO = modelMapper.map(notification, NotificationDTO.class);
        notificationDTO.setPostDTO(modelMapper.map(notification.getPost(), PostDTO.class));
        return notificationDTO;
    }
}
