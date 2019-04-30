package com.kltn.motelservice.model;

import com.kltn.motelservice.entity.RoleName;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

public class UserDTO {
    private Long id;

    private String fullName;

    private String email;

    private String address;

    private String phone;

    private boolean block;

    @Enumerated(EnumType.STRING)
    private List<RoleName> role;

    public UserDTO() {
    }

    public UserDTO(Long id, String fullName, String email, String address, String phone, boolean block) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.block = block;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleName> getRole() {
        return role;
    }

    public void setRole(List<RoleName> role) {
        this.role = role;
    }
}
