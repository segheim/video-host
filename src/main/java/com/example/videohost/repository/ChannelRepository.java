package com.example.videohost.repository;

import com.example.videohost.model.Channel;
import com.example.videohost.model.ChannelShort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ChannelRepository extends BaseRepository<Channel> {

    Optional<Channel> findByName(String name);

    @Query(
            """
            SELECT  c.name as name, COUNT(s) as countSubscribers, c.language as language,
                    c.avatar as avatar, ca.name as category                   
                    FROM Channel c
                    LEFT JOIN c.category ca
                    LEFT JOIN c.subscribers s
                    WHERE (:name IS NULL OR c.name ILIKE %:name%)
                    AND (:language IS NULL OR c.language LIKE %:language%)
                    AND (:category IS NULL OR ca.name LIKE %:category%)
                    GROUP BY c.id, ca.id
            """
    )
    Page<ChannelShort> findAllByName(String name, String language, String category, Pageable pageable);
}
