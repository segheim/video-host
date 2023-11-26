package com.example.videohost.repository;

import com.example.videohost.model.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User>{

    Optional<User> findUserByEmail(String email);

}
