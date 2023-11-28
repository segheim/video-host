package com.example.videohost.mapper;

import com.example.videohost.dto.UserDto;
import com.example.videohost.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface UserMapper {

    UserDto toDto(User user);

    User fromDto(UserDto userDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User fromDtoForUpdate(UserDto userDto, @MappingTarget User user);

}
