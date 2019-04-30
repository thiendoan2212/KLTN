package com.kltn.motelservice.model;

import java.time.LocalDateTime;

public class CommentDTO {
    private long id;

    private String content;

    private LocalDateTime lastUpdate;

    private Long idPost;

    private Long idUser;

    private String fullName;

    public CommentDTO() {
    }

    public CommentDTO(long id, String content, LocalDateTime lastUpdate, Long idPost, Long idUser, String fullName) {
        this.id = id;
        this.content = content;
        this.lastUpdate = lastUpdate;
        this.idPost = idPost;
        this.idUser = idUser;
        this.fullName = fullName;
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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
