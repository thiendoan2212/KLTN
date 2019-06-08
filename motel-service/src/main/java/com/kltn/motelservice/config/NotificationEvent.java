package com.kltn.motelservice.config;

import com.kltn.motelservice.entity.Post;
import org.springframework.context.ApplicationEvent;

public class NotificationEvent extends ApplicationEvent {

    private Post post;

    public NotificationEvent(Object source, Post post) {
        super(source);
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}
