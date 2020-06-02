package com.ssuriyan.hoa.hoaseriesservice.service;

import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import com.ssuriyan.hoa.hoaseriesservice.model.Arc;
import com.ssuriyan.hoa.hoaseriesservice.model.Episode;
import com.ssuriyan.hoa.hoaseriesservice.model.Type;
import com.ssuriyan.hoa.hoaseriesservice.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private ArcService arcService;

    @Autowired
    private AnimeService animeService;

    public Episode saveEpisode(Episode episode) {
        return episodeRepository.save(episode);
    }

    public Episode insertEpisode(Episode episode) {

        //TODO try with single database read to get the anime

        Episode savedEpisode = null;
        Arc arc = arcService.getOne(episode.getArc().getId());
        if ((savedEpisode = episodeRepository.getByEpisodeNumber(episode.getEpisodeNumber())) != null) {
            //Episode already exists! :(
            return savedEpisode;
        }
        savedEpisode = episodeRepository.save(episode);
        //updating episode count in anime
        Anime anime = animeService.getOne(arc.getAnime().getId());
        anime.setEpisodeCount(anime.getEpisodeCount() + 1);
        animeService.saveAnime(anime);
        return savedEpisode;
    }

    public List<Episode> getEpisodesByArc(Arc arc) {
        return  episodeRepository.findByArcOrderByEpisodeNumber(arc);
    }

    public Episode getOne(String episodeId) {
        return episodeRepository.getOne(episodeId);
    }

    public Episode updateEpisode(Episode episode) {
        Episode savedEpisode = episodeRepository.getOne(episode.getId());
        if(savedEpisode != null) {
            if (!episode.getName().isEmpty()) {
                savedEpisode.setName(episode.getName());
            }
            if (episode.getDuration() != 0.0) {
                savedEpisode.setDuration(episode.getDuration());
            }
            if (episode.getType() != null) {
                savedEpisode.setType(episode.getType());
            }
            if (episode.getEpisodeNumber() != 0) {
                if(episodeRepository.getByEpisodeNumber(episode.getEpisodeNumber()) != null) {
                    //episode number already in use
                    return null;
                }
                savedEpisode.setEpisodeNumber(episode.getEpisodeNumber());
            }
            return episodeRepository.save(savedEpisode);
        }
        return savedEpisode;
    }

    public void deleteEpisode(String episodeId) {
        episodeRepository.deleteById(episodeId);
    }

    public void deleteEpisodesByArc(Arc arc) {
        episodeRepository.deleteEpisodesByArc(arc);
    }

}
