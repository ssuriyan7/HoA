package com.ssuriyan.hoa.hoaseriesservice.repository;


import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import com.ssuriyan.hoa.hoaseriesservice.model.Arc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArcRepository extends JpaRepository<Arc, String> {
    public void deleteByAnime(Anime anime);
}
