package com.example.videohost.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelDto {

    private String name;
    private Long countSubscribers;
    private String language;
    private String avatar;
    private String category;
}
