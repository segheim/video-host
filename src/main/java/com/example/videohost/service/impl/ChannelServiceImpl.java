package com.example.videohost.service.impl;

import com.example.videohost.dto.ChannelDto;
import com.example.videohost.dto.ChannelRequestDto;
import com.example.videohost.dto.ChannelResponseDto;
import com.example.videohost.dto.UserDto;
import com.example.videohost.exception.ExistException;
import com.example.videohost.exception.NotFoundException;
import com.example.videohost.mapper.ChannelMapper;
import com.example.videohost.model.*;
import com.example.videohost.repository.CategoryRepository;
import com.example.videohost.repository.ChannelRepository;
import com.example.videohost.repository.UserRepository;
import com.example.videohost.service.ChannelService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ChannelMapper mapper;

    @Override
    public ChannelResponseDto add(ChannelRequestDto channelDto) {
        channelRepository.findByName(channelDto.getName()).ifPresent((c) -> {
            throw new ExistException(String.format("Channel with name = %s is already exist", c.getName()));
        });
        User user = userRepository.findById(channelDto.getAuthorId()).orElseThrow(() -> new NotFoundException("User is absent"));

        Category category = categoryRepository.findById(channelDto.getCategoryId()).orElseThrow(() -> new NotFoundException("Category is absent"));

        Channel channel = mapper.fromRequestDto(channelDto);
        channel.setAuthor(user);
        channel.setCategory(category);

        return mapper.toResponseDto(channelRepository.save(channel));
    }

    @Override
    public ChannelResponseDto update(ChannelRequestDto channelDto) {
        Optional<Channel> channelFromRepository = channelRepository.findById(channelDto.getId());
        if (channelFromRepository.isEmpty()) {
            throw new NotFoundException(String.format("Channel with id = %d not found", channelDto.getId()));
        }

        Channel entity = mapper.fromDtoForUpdate(channelDto, channelFromRepository.get());
        Channel channel = channelRepository.save(entity);
        return mapper.toResponseDto(channel);
    }

    @Override
    public ChannelResponseDto findById(Long id) {
        Channel channel = channelRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Channel with id = %d not found", id)));
        return mapper.toResponseDto(channel);
    }

    @Override
    public Boolean subscribe(Long channelId, UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElseThrow(() ->
                new NotFoundException(String.format("User with id = %d not found", userDto.getId())));
        Channel channel = channelRepository.findById(channelId).orElseThrow(() ->
                new NotFoundException(String.format("Channel with id = %d not found", channelId)));
        if(channel.getSubscribers().stream().anyMatch((s) -> channelId == s.getId())) {
            throw new ExistException(String.format("User with id = %d already subscribed on channel: %s", userDto.getId(), channel.getName()));
        }
        user.getChannels().add(channel);
        return userRepository.save(user) != null ? true : false;
    }

    @Override
    public Boolean unsubscribe(Long channelId, UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElseThrow(() ->
                new NotFoundException(String.format("User with id = %d not found", userDto.getId())));
        Channel channel = channelRepository.findById(channelId).orElseThrow(() ->
                new NotFoundException(String.format("Channel with id = %d not found", channelId)));
        List<User> subscribers = channel.getSubscribers();
        if(subscribers.stream().anyMatch((s) -> channelId == s.getId())) {
            throw new ExistException(String.format("User with id = %d already subscribed on channel: %s", userDto.getId(), channel.getName()));
        }
        List<Channel> channels = user.getChannels();
        List<Channel> newChannels = channels.stream()
                .filter(c -> !channelId.equals(c.getId()))
                .collect(Collectors.toList());

        user.setChannels(newChannels);
        return userRepository.save(user)!= null ? true : false;
    }

    @Override
    public Page<ChannelDto> findAll(String name, String language, String category, Pageable pageable) {
        Page<ChannelShort> all = channelRepository.findAllByName(name, language, category, pageable);
        return all.map(mapper::toDto);
    }
}