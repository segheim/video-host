package com.example.videohost.dto;

import com.example.videohost.model.Category;
import com.example.videohost.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelResponseDto {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime dateCreate;
    private String language;
    private String avatar;
    private Category category;
    private User author;
}
