package com.ssuriyan.hoa.services.series.service;

import com.ssuriyan.hoa.services.series.model.Anime;
import com.ssuriyan.hoa.services.series.model.Arc;
import com.ssuriyan.hoa.services.series.repository.ArcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ArcService {

    @Autowired
    private ArcRepository arcRepository;

    public Arc insertArc(Arc arc) {
        return arcRepository.save(arc);
    }

    public void deleteArc(String id) {
        arcRepository.deleteById(id);
    }

    public void deleteArcByAnime(Anime anime) {
        arcRepository.deleteByAnime(anime);
    }
}
