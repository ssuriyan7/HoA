package com.ssuriyan.hoa.hoaseriesservice.repository;


import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import com.ssuriyan.hoa.hoaseriesservice.model.Arc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArcRepository extends JpaRepository<Arc, String> {
    public void deleteByAnime(Anime anime);
    public Arc getByArcNumber(int arcNumber);
    public List<Arc> findByAnime(Anime anime);
    public List<Arc> findByAnimeOrderByArcNumber(Anime anime);
}
