package com.example.videohost.service;

import com.example.videohost.dto.UserDto;
import com.example.videohost.model.Channel;
import com.example.videohost.model.User;

import java.util.List;

public interface UserService {

    UserDto add(UserDto userDto);

    UserDto update(UserDto userDto);

    User findById(Long id);

    List<String> getSubscribeChannels(Long id);

}
