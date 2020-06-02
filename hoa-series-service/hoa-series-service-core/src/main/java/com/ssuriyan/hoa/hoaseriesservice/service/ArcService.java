package com.ssuriyan.hoa.hoaseriesservice.service;


import com.ssuriyan.hoa.hoaseriesservice.dto.ArcDTO;
import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import com.ssuriyan.hoa.hoaseriesservice.model.Arc;
import com.ssuriyan.hoa.hoaseriesservice.repository.ArcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArcService {

    @Autowired
    private ArcRepository arcRepository;

    @Autowired
    private AnimeService animeService;

    @Autowired
    private EpisodeService episodeService;

    public Arc insertArc(Arc arc) {
        Arc savedArc = null;
        if ((savedArc = arcRepository.getByArcNumber(arc.getArcNumber())) != null) {
            return savedArc;
        }
        return arcRepository.save(arc);
    }

    public Arc updateArc(Arc arc) {
        Arc savedArc = arcRepository.getOne(arc.getId());
        if (savedArc != null) {
            if (!arc.getName().isEmpty()) {
                savedArc.setName(arc.getName());
            }

            if(arc.getArcNumber() != 0) {
                if(arcRepository.getByArcNumber(arc.getArcNumber()) != null){
                    //arc number already in use
                    return null;
                }
                savedArc.setArcNumber(arc.getArcNumber());
            }
            return  arcRepository.save(savedArc);
        }
        return  savedArc;
    }

    public Arc getOne(String arcId) {
        return arcRepository.getOne(arcId);
    }

    public void deleteArc(Arc arc) {
        episodeService.deleteEpisodesByArc(arc);
        arcRepository.deleteById(arc.getId());
    }

    public void deleteArcsByAnime(Anime anime) {
        List<Arc> arcs = arcRepository.findByAnime(anime);
        for (Arc arc : arcs) {
            episodeService.deleteEpisodesByArc(arc);
        }
        arcRepository.deleteByAnime(anime);
    }

    public List<Arc> getArcsByAnime(Anime anime) {
        return arcRepository.findByAnimeOrderByArcNumber(anime);
    }

}