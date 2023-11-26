package com.example.videohost.repository;

import com.example.videohost.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseRepository<T extends AbstractEntity> extends JpaRepository<T, Long>, PagingAndSortingRepository<T, Long> {

}
