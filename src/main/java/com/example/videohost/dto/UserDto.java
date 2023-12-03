package com.example.videohost.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @NotNull
    @Size(max = 50)
    private String nickname;
    @NotNull
    @Size(max = 80)
    private String name;
    @NotNull
    @Email
    private String email;

}