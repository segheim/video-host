package com.example.videohost.service;

import com.example.videohost.dto.ChannelRequestDto;
import com.example.videohost.dto.ChannelResponseDto;

public interface ChannelService {

    ChannelResponseDto add(ChannelRequestDto channelRequestDto);

    ChannelRequestDto update(ChannelRequestDto channelRequestDto);
}
