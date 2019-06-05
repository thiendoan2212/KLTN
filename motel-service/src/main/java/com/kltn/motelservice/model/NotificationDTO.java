package com.kltn.motelservice.model;

import java.time.LocalDateTime;

public class NotificationDTO {
    private Long id;

    private PostDTO postDTO;

    private boolean seen;

    private LocalDateTime createAt;

    public NotificationDTO() {
    }

    public NotificationDTO(Long id, PostDTO postDTO, boolean seen, LocalDateTime createAt) {
        this.id = id;
        this.postDTO = postDTO;
        this.seen = seen;
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PostDTO getPostDTO() {
        return postDTO;
    }

    public void setPostDTO(PostDTO postDTO) {
        this.postDTO = postDTO;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
