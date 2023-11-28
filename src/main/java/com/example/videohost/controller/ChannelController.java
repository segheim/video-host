package com.example.videohost.controller;

import com.example.videohost.dto.ChannelRequestDto;
import com.example.videohost.dto.ChannelResponseDto;
import com.example.videohost.dto.UserDto;
import com.example.videohost.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/{id}")
    public ResponseEntity<ChannelResponseDto> updateChannel(@PathVariable("id") Long id, @RequestBody ChannelRequestDto channelDto) {
        channelDto.setId(id);
        ChannelResponseDto channel = channelService.update(channelDto);
        return new ResponseEntity<>(channel, HttpStatus.OK);
    }

    @PostMapping("/{id}/subscribe")
    public ResponseEntity<Boolean> subscribe(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        Boolean isSubscribe = channelService.subscribe(id, userDto);
        return new ResponseEntity<>(isSubscribe, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/unsubscribe")
    public ResponseEntity<Boolean> unsubscribe(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        Boolean isUnsubscribe = channelService.unsubscribe(id, userDto);
        return new ResponseEntity<>(isUnsubscribe, HttpStatus.CREATED);
    }
}
