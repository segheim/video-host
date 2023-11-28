package com.example.videohost.repository;

import com.example.videohost.model.Channel;

import java.util.Optional;

public interface ChannelRepository extends BaseRepository<Channel> {

    Optional<Channel> findByName(String name);

}
