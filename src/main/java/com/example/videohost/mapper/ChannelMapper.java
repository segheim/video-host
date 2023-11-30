package com.example.videohost.mapper;

import com.example.videohost.dto.ChannelDto;
import com.example.videohost.dto.ChannelRequestDto;
import com.example.videohost.dto.ChannelResponseDto;
import com.example.videohost.model.Channel;
import com.example.videohost.model.ChannelShort;
import com.example.videohost.service.CategoryService;
import com.example.videohost.service.UserService;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserService.class, CategoryService.class})
public interface ChannelMapper {

    ChannelResponseDto toResponseDto(Channel channel);

    Channel fromRequestDto(ChannelRequestDto channelDto);

    @Mapping(source = "authorId", target = "author")
    @Mapping(source = "categoryId", target = "category")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Channel fromDtoForUpdate(ChannelRequestDto channelRequestDto, @MappingTarget Channel channel);

    ChannelDto toDto(ChannelShort channel);

}
