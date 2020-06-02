package com.ssuriyan.hoa.hoaseriesservice.repository;


import com.ssuriyan.hoa.hoaseriesservice.model.Arc;
import com.ssuriyan.hoa.hoaseriesservice.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, String> {
    public Episode getByEpisodeNumber(int episodeNumber);
    public int countByArc_Id(String arcId);
    public List<Episode> findByArcOrderByEpisodeNumber(Arc arc);
    public void deleteEpisodesByArc(Arc arc);
}