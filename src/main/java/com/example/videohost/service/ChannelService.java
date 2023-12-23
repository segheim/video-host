package com.example.videohost.service;

import com.example.videohost.dto.ChannelDto;
import com.example.videohost.dto.ChannelRequestDto;
import com.example.videohost.dto.ChannelResponseDto;
import com.example.videohost.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChannelService {

    ChannelResponseDto add(ChannelRequestDto channelRequestDto);

    ChannelResponseDto update(ChannelRequestDto channelRequestDto);

    ChannelResponseDto findById(Long id);

    Boolean subscribe(Long channelId, UserDto userDto);

    Boolean unsubscribe(Long channelId, UserDto userDto);

    Page<ChannelDto> findAll(String name, String language, String category, Pageable pageable);

}
