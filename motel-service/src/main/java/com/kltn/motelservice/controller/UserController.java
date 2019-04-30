package com.kltn.motelservice.controller;

import com.kltn.motelservice.entity.Role;
import com.kltn.motelservice.entity.RoleName;
import com.kltn.motelservice.entity.User;
import com.kltn.motelservice.mapper.UserMapper;
import com.kltn.motelservice.model.UserDTO;
import com.kltn.motelservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@PreAuthorize("#oauth2.hasAnyScope('read')") // for authenticated request (logged)
public class UserController {

    private UserService userService;

    private final UserMapper mapper = UserMapper.INSTANCE;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')") // only ADMIN can get list users
    public Page<UserDTO> getAlLUser(@PageableDefault(page = 0, size = 12) Pageable page) {
        return userService.selectPageOfUsers(page).map(mapper::entityToDTO);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") Long id, OAuth2Authentication auth) {
        if (!validRequest(auth, id)) throw new AccessDeniedException("Access dined");

        User user = userService.selectUserById(id);

        return mapper.entityToDTO(user);
    }

    @PutMapping("/{id}")
    public UserDTO updateProfile(@PathVariable("id") Long id,
                                 @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        User user = userService.changeProfile(userDTO);

        return mapper.entityToDTO(user);
    }

    @PutMapping("/{id}/block")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public UserDTO blockUser(@PathVariable("id") Long id) {
        User user = userService.blockUserById(id, true);

        return mapper.entityToDTO(user);
    }

    @PutMapping("/{id}/unblock")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public UserDTO unblockUser(@PathVariable("id") Long id) {
        User user = userService.blockUserById(id, false);

        return mapper.entityToDTO(user);
    }

    @PostMapping("/{id}/password")
    public UserDTO changePasswordAUser(@PathVariable("id") Long id,
                                       @RequestParam("password") String newPassword,
                                       @RequestParam("oldPassword") String oldPassword,
                                       OAuth2Authentication auth) throws Exception {
        if (!validRequest(auth, id)) throw new AccessDeniedException("Access dined");

        User user = userService.changePassword(id, oldPassword, newPassword);

        return mapper.entityToDTO(user);
    }

    //user request change profile or admin
    boolean validRequest(OAuth2Authentication auth, Long userId) {
        User authUser = userService.selectUserByEmail(auth.getName());

        // has ROLE_ADMIN or has userid equal userid request
        return authUser.getRoles().stream().map(Role::getName).anyMatch(roleName -> roleName == RoleName.ROLE_ADMIN)
                || authUser.getId().equals(userId);
    }
}
