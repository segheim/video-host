package com.example.videohost.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelRequestDto {

    private Long id;
    @NotNull
    @Size(max = 50)
    private String name;
    private String description;
    @NotNull
    @Size(max = 10)
    @Pattern(regexp = "En|Ru|Fr|Pl|It|Gr|Sb|Lt")
    private String language;
    private String avatar;
    @NotNull
    private Long authorId;
    @NotNull
    private Long categoryId;

}