package com.ssuriyan.hoa.hoaseriesservice.service;


import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import com.ssuriyan.hoa.hoaseriesservice.model.SeriesArc;
import com.ssuriyan.hoa.hoaseriesservice.repository.ArcRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public SeriesArc insertArc(SeriesArc seriesArc) {
        SeriesArc savedSeriesArc = null;
        if ((savedSeriesArc = arcRepository.getByArcNumber(seriesArc.getArcNumber())) != null) {
            return savedSeriesArc;
        }
        return arcRepository.save(seriesArc);
    }

    public SeriesArc updateArc(SeriesArc seriesArc) {
        SeriesArc savedSeriesArc = arcRepository.getOne(seriesArc.getId());
        if (savedSeriesArc != null) {
            if (!seriesArc.getName().isEmpty()) {
                savedSeriesArc.setName(seriesArc.getName());
            }

            if(seriesArc.getArcNumber() != 0) {
                if(arcRepository.getByArcNumber(seriesArc.getArcNumber()) != null){
                    //arc number already in use
                    return null;
                }
                savedSeriesArc.setArcNumber(seriesArc.getArcNumber());
            }
            return  arcRepository.save(savedSeriesArc);
        }
        return savedSeriesArc;
    }

    public SeriesArc getOne(String arcId) {
        return arcRepository.getOne(arcId);
    }

    public void deleteArc(SeriesArc seriesArc) {
        episodeService.deleteEpisodesByArc(seriesArc);
        arcRepository.deleteById(seriesArc.getId());
    }

    public void deleteArcsByAnime(Anime anime) {
        List<SeriesArc> seriesArcs = arcRepository.findByAnime(anime);
        for (SeriesArc seriesArc : seriesArcs) {
            episodeService.deleteEpisodesByArc(seriesArc);
        }
        arcRepository.deleteByAnime(anime);
    }

    public List<SeriesArc> getArcsByAnime(Anime anime) {
        return arcRepository.findByAnimeOrderByArcNumber(anime);
    }

}