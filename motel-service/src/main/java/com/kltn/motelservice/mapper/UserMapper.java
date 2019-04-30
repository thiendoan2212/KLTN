package com.kltn.motelservice.mapper;

import com.kltn.motelservice.entity.User;
import com.kltn.motelservice.model.UserDTO;
import org.mapstruct.Mapper;

import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({})
    UserDTO entityToDTO(User user);
}
