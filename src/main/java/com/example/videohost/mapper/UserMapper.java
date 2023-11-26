package com.example.videohost.mapper;

import com.example.videohost.dto.UserDto;
import com.example.videohost.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto toDto(User user);

    User fromDto(UserDto userDto);

}
