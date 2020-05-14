package com.ssuriyan.hoa.hoaseriesservice.repository;


import com.ssuriyan.hoa.hoaseriesservice.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, String> {
    public Episode getByEpisodeNumber(int episodeNumber);
    public int countByArc_Id(String arcId);
}