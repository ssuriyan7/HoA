package com.ssuriyan.hoa.hoaseriesservice.service;

import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import com.ssuriyan.hoa.hoaseriesservice.model.Episode;
import com.ssuriyan.hoa.hoaseriesservice.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    public Episode insertEpisode(Episode episode) {
        return episodeRepository.save(episode);
    }

    public void deleteEpisode(String id) {
        episodeRepository.deleteById(id);
    }

    public void deleteEpisodesByAnime(Anime anime) {
        episodeRepository.deleteByAnime(anime);
    }
}
