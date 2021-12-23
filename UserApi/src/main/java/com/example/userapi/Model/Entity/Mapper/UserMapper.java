package com.example.userapi.Model.Entity.Mapper;

import com.example.userapi.Model.Entity.User;
import com.example.userapi.Model.Entity.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserDto toUserDto(User user);
}
