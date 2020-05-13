package com.ssuriyan.hoa.services.series.service;

import com.ssuriyan.hoa.services.series.model.Anime;
import com.ssuriyan.hoa.services.series.model.Episode;
import com.ssuriyan.hoa.services.series.repository.EpisodeRepository;
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
