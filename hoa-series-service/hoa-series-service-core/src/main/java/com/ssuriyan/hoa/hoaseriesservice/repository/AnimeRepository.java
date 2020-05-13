package com.ssuriyan.hoa.services.series.repository;

import com.ssuriyan.hoa.services.series.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, String> {
    public void deleteAnimeById(String id);
}
