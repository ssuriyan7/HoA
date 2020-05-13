package com.ssuriyan.hoa.services.series.repository;

import com.ssuriyan.hoa.services.series.model.Anime;
import com.ssuriyan.hoa.services.series.model.Arc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArcRepository extends JpaRepository<Arc, String> {
    public void deleteByAnime(Anime anime);
}
