/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.Role;
import com.kltn.motelservice.entity.RoleName;
import com.kltn.motelservice.entity.User;
import com.kltn.motelservice.model.AccountDto;
import com.kltn.motelservice.model.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author 97lynk
 */
public interface UserService {

    User selectUserByEmail(String userName);

    Role selectRoleByName(RoleName name);

    User changePassword(Long id, String newPassword, String oldPassword, String role) throws Exception;

    Page<User> selectPageOfUsersInRoles(Pageable page, List<String> rolesString);

    User blockUserById(Long id, boolean block);

    User selectUserById(Long id);

    User changeProfile(UserDTO userDTO, boolean admin);

    User changeRole(Long id, List<RoleName> role);

    User registration(AccountDto accountDto);

    void changeAvatar(Long id, byte[] fileBytes);

}
