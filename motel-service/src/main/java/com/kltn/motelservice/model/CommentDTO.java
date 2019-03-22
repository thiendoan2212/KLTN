package com.kltn.motelservice.model;

import java.time.LocalDateTime;

public class CommentDTO {
    private long id;

    private String content;

    private LocalDateTime lastUpdate;

    private Long idPost;

    private String username;

    public CommentDTO() {
    }

    public CommentDTO(long id, String content, LocalDateTime lastUpdate, Long idPost, String username) {
        this.id = id;
        this.content = content;
        this.lastUpdate = lastUpdate;
        this.idPost = idPost;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
