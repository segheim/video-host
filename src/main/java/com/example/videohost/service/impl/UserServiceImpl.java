package com.example.videohost.service.impl;

import com.example.videohost.dto.UserDto;
import com.example.videohost.exception.NotFoundException;
import com.example.videohost.mapper.UserMapper;
import com.example.videohost.model.Channel;
import com.example.videohost.model.User;
import com.example.videohost.repository.UserRepository;
import com.example.videohost.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public UserDto add(UserDto userDto) {
        userRepository.findUserByEmail(userDto.getEmail()).ifPresent((user) -> {
            throw new NotFoundException("Email is present");
        });
        User user = userRepository.save(mapper.fromDto(userDto));
        return mapper.toDto(user);
    }

    @Override
    public UserDto update(UserDto userDto) {
        Optional<User> userFromRepository = userRepository.findById(userDto.getId());
        if (userFromRepository.isEmpty()) {
            throw new NotFoundException(String.format("User with id = %d not found", userDto.getId()));
        }
        User user = mapper.fromDtoForUpdate(userDto, userFromRepository.get());
        return mapper.toDto(userRepository.save(user));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("User is absent");
        });
    }

    @Override
    public List<String> getSubscribeChannels(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new NotFoundException(String.format("User with id = %d not found", id)));
        return user.getChannels().stream().map(Channel::getName).collect(Collectors.toList());
    }
}
