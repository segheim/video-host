package com.example.videohost.mapper;

import com.example.videohost.dto.ChannelRequestDto;
import com.example.videohost.dto.ChannelResponseDto;
import com.example.videohost.model.Channel;
import com.example.videohost.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserService.class})
public interface ChannelMapper {

    ChannelResponseDto toResponseDto(Channel channel);

    @Mapping(source = "authorId", target = "author")
    Channel fromDto(ChannelRequestDto channelDto);

}
