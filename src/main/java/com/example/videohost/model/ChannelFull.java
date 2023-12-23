package com.example.videohost.model;

import java.time.LocalDateTime;

public interface ChannelFull {

    String getName();

    Long getCountSubscribers();

    String getLanguage();

    String getAvatar();

    String getCategory();

    User getAuthor();

    String getDescription();

    LocalDateTime getDateCreate();
}
