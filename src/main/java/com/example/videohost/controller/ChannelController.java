package com.example.videohost.controller;

import com.example.videohost.dto.ChannelDto;
import com.example.videohost.dto.ChannelRequestDto;
import com.example.videohost.dto.ChannelResponseDto;
import com.example.videohost.dto.UserDto;
import com.example.videohost.service.ChannelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channels")
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;

    @PostMapping
    public ResponseEntity<ChannelResponseDto> addChannel(@Valid @RequestBody ChannelRequestDto channelDto) {
        ChannelResponseDto channel = channelService.add(channelDto);
        return new ResponseEntity<>(channel, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ChannelResponseDto> updateChannel(@PathVariable("id") Long id, @Valid @RequestBody ChannelRequestDto channelDto) {
        channelDto.setId(id);
        ChannelResponseDto channel = channelService.update(channelDto);
        return new ResponseEntity<>(channel, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChannelResponseDto> getChannel(@PathVariable("id") Long id) {
        ChannelResponseDto channel = channelService.findById(id);
        return new ResponseEntity<>(channel, HttpStatus.OK);
    }

    @PostMapping("/{id}/subscribe")
    public ResponseEntity<Boolean> subscribe(@PathVariable("id") Long id, @Valid @RequestBody UserDto userDto) {
        Boolean isSubscribe = channelService.subscribe(id, userDto);
        return new ResponseEntity<>(isSubscribe, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/unsubscribe")
    public ResponseEntity<Boolean> unsubscribe(@PathVariable("id") Long id, @Valid @RequestBody UserDto userDto) {
        Boolean isUnsubscribe = channelService.unsubscribe(id, userDto);
        return new ResponseEntity<>(isUnsubscribe, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ChannelDto>> findAll(@RequestParam(required = false) String name,
                                              @RequestParam(required = false) String language,
                                              @RequestParam(required = false) String category,
                                              @RequestParam int page,
                                              @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ChannelDto> channels = channelService.findAll(name, language, category, pageable);
        return new ResponseEntity<>(channels, HttpStatus.OK);
    }
}
