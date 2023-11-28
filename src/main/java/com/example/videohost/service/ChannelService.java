package com.example.videohost.service;

import com.example.videohost.dto.ChannelRequestDto;
import com.example.videohost.dto.ChannelResponseDto;
import com.example.videohost.dto.UserDto;

public interface ChannelService {

    ChannelResponseDto add(ChannelRequestDto channelRequestDto);

    ChannelResponseDto update(ChannelRequestDto channelRequestDto);

    Boolean subscribe(Long channelId, UserDto userDto);

    Boolean unsubscribe(Long channelId, UserDto userDto);

}
