package com.example.videohost.service.impl;

import com.example.videohost.dto.ChannelRequestDto;
import com.example.videohost.dto.ChannelResponseDto;
import com.example.videohost.exception.NotFoundException;
import com.example.videohost.mapper.ChannelMapper;
import com.example.videohost.model.Category;
import com.example.videohost.model.Channel;
import com.example.videohost.model.User;
import com.example.videohost.repository.CategoryRepository;
import com.example.videohost.repository.ChannelRepository;
import com.example.videohost.repository.UserRepository;
import com.example.videohost.service.ChannelService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Data
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ChannelMapper mapper;

    @Override
    public ChannelResponseDto add(ChannelRequestDto channelDto) {
        User user = userRepository.findById(channelDto.getAuthorId()).orElseThrow(() -> {
            throw new NotFoundException("User is absent");
        });

        Category category = categoryRepository.findById(channelDto.getCategoryId()).orElseThrow(() -> {
            throw new NotFoundException("Category is absent");
        });

        Channel channel = mapper.fromDto(channelDto);
        channel.setAuthor(user);
        channel.setCategory(category);
        return mapper.toResponseDto(channelRepository.save(channel));
    }

    @Override
    public ChannelRequestDto update(ChannelRequestDto channelDto) {
        return null;
    }
}
