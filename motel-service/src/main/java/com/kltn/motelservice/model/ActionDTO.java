package com.kltn.motelservice.model;

import com.kltn.motelservice.entity.ActionName;

public class ActionDTO {
    private Long id;

    private String username;

    private ActionName action;

    private String postTitle;

    private Long postId;

    public ActionDTO(Long id, String username, ActionName action, String postTitle, Long postId) {
        this.id = id;
        this.username = username;
        this.action = action;
        this.postTitle = postTitle;
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ActionName getAction() {
        return action;
    }

    public void setAction(ActionName action) {
        this.action = action;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
