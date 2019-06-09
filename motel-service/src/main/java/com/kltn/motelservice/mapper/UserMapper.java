package com.kltn.motelservice.mapper;

import com.kltn.motelservice.entity.Role;
import com.kltn.motelservice.entity.User;
import com.kltn.motelservice.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({})
    UserDTO entityToDTO(User user);

    default UserDTO entityToDTOWithRoles(User user) {
        UserDTO userDTO = entityToDTO(user);
        userDTO.setRole(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        return userDTO;
    }
}
