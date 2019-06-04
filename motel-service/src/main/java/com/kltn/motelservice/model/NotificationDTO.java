package com.kltn.motelservice.model;

public class NotificationDTO {
    private Long id;

    private PostDTO postDTO;

    private boolean seen;

    public NotificationDTO() {
    }

    public NotificationDTO(Long id, PostDTO postDTO, boolean seen) {
        this.id = id;
        this.postDTO = postDTO;
        this.seen = seen;
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
}
