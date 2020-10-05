package com.ssuriyan.hoa.hoaseriesservice.repository;


import com.ssuriyan.hoa.hoaseriesservice.model.SeriesArc;
import com.ssuriyan.hoa.hoaseriesservice.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, String> {
    public Episode getByEpisodeNumber(int episodeNumber);
    //public int countBySeries_Arc_id(String arcId);
    public List<Episode> findBySeriesArcOrderByEpisodeNumber(SeriesArc seriesArc);
    public void deleteEpisodesBySeriesArc(SeriesArc seriesArc);
}