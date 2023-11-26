package com.example.videohost.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelRequestDto {

    private Long id;
    private String name;
    private String description;
    private String language;
    private String avatar;
    private Long authorId;
    private Long categoryId;

}