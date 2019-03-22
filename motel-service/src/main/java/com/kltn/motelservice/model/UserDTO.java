package com.kltn.motelservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class UserDTO {
    private Long id;

    private String username;

    private String password;

    private String address;

    private String phone;

    private boolean isBlock;

    private List<PostDTO> postDTOS;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String password, String address, String phone, boolean isBlock, List<PostDTO> postDTOS) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.isBlock = isBlock;
        this.postDTOS = postDTOS;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setBlock(boolean block) {
        isBlock = block;
    }

    public List<PostDTO> getPostDTOS() {
        return postDTOS;
    }

    public void setPostDTOS(List<PostDTO> postDTOS) {
        this.postDTOS = postDTOS;
    }
}
