package com.ssuriyan.hoa.hoaseriesservice.repository;

import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, String> {
    public void deleteAnimeById(String id);
    public Anime findByName(String name);
}
