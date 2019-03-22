package com.kltn.motelservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private boolean isVerify;

    private LocalDateTime lastUpdate;

    private boolean isDelete;

    @NotBlank
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "post",
            orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "post",
            orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @NotBlank
    @OneToOne(cascade = CascadeType.ALL,
            mappedBy = "post",
            fetch = FetchType.LAZY,
            optional = false)
    private Accomodation accomodation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Post() {
    }

    public Post(@NotBlank String title, @NotBlank String content, boolean isVerify, LocalDateTime lastUpdate,
                boolean isDelete, @NotBlank List<Image> images, List<Comment> comments, @NotBlank Accomodation accomodation, User user) {
        this.title = title;
        this.content = content;
        this.isVerify = isVerify;
        this.lastUpdate = lastUpdate;
        this.isDelete = isDelete;
        this.images = images;
        this.comments = comments;
        this.accomodation = accomodation;
        this.user = user;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Accomodation getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(Accomodation accomodation) {
        this.accomodation = accomodation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
