package com.kltn.motelservice.model;

import java.time.LocalDateTime;

public class PostDTO {
    private long id;

    private String title;

    private String content;

    private boolean isApproved;

    private boolean isNotApproved;

    private LocalDateTime createAt;

    private LocalDateTime lastUpdate;

    private boolean isDelete;

    private String username;

    private AccomodationDTO accomodationDTO;

    public PostDTO() {
    }

    public PostDTO(long id, String title, String content, boolean isApproved, boolean isNotApproved, LocalDateTime createAt,
                   LocalDateTime lastUpdate, boolean isDelete, String username, AccomodationDTO accomodationDTO) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isApproved = isApproved;
        this.isNotApproved = isNotApproved;
        this.createAt = createAt;
        this.lastUpdate = lastUpdate;
        this.isDelete = isDelete;
        this.username = username;
        this.accomodationDTO = accomodationDTO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public boolean isNotApproved() {
        return isNotApproved;
    }

    public void setNotApproved(boolean notApproved) {
        isNotApproved = notApproved;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AccomodationDTO getAccomodationDTO() {
        return accomodationDTO;
    }

    public void setAccomodationDTO(AccomodationDTO accomodationDTO) {
        this.accomodationDTO = accomodationDTO;
    }
}
