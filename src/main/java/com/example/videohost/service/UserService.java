package com.example.videohost.service;

import com.example.videohost.dto.UserDto;
import com.example.videohost.model.User;

public interface UserService {

    UserDto add(UserDto userDto);

    UserDto update(UserDto userDto);

    User findById(Long id);
}
