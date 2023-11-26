package com.example.videohost.controller;

import com.example.videohost.dto.ChannelRequestDto;
import com.example.videohost.dto.ChannelResponseDto;
import com.example.videohost.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/channels")
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;

    @PostMapping
    public ResponseEntity<ChannelResponseDto> addChannel(@RequestBody ChannelRequestDto channelDto) {
        ChannelResponseDto channel = channelService.add(channelDto);
        return new ResponseEntity<>(channel, HttpStatus.CREATED);
    }
}
