package com.kltn.motelservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class PostDTO {
    private long id;

    private String title;

    private String content;

    private boolean isVerify;

    private LocalDateTime lastUpdate;

    private boolean isDelete;

    private AccomodationDTO accomodationDTO;

    public PostDTO() {
    }

    public PostDTO(long id, String title, String content, boolean isVerify, LocalDateTime lastUpdate,
                   boolean isDelete, AccomodationDTO accomodationDTO) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isVerify = isVerify;
        this.lastUpdate = lastUpdate;
        this.isDelete = isDelete;
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

    public boolean isVerify() {
        return isVerify;
    }

    public void setVerify(boolean verify) {
        isVerify = verify;
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

    public AccomodationDTO getAccomodationDTO() {
        return accomodationDTO;
    }

    public void setAccomodationDTO(AccomodationDTO accomodationDTO) {
        this.accomodationDTO = accomodationDTO;
    }
}
