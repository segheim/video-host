package com.example.videohost.dto;

import com.example.videohost.model.Category;
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
