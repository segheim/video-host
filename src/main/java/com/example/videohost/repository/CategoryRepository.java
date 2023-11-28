package com.example.videohost.repository;

import com.example.videohost.model.Category;

import java.util.Optional;

public interface CategoryRepository extends BaseRepository<Category>{

    Optional<Category> findById(Long id);
}
