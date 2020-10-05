package com.ssuriyan.hoa.hoaseriesservice.repository;


import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import com.ssuriyan.hoa.hoaseriesservice.model.SeriesArc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArcRepository extends JpaRepository<SeriesArc, String> {
    public void deleteByAnime(Anime anime);
    public SeriesArc getByArcNumber(int arcNumber);
    public List<SeriesArc> findByAnime(Anime anime);
    public List<SeriesArc> findByAnimeOrderByArcNumber(Anime anime);
}
