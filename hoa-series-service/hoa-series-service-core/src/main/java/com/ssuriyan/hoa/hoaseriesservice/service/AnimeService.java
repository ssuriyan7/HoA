package com.ssuriyan.hoa.services.series.service;

import com.ssuriyan.hoa.services.series.model.Anime;
import com.ssuriyan.hoa.services.series.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public Anime insertAnime(Anime anime) {
        return animeRepository.save(anime);
    }

    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }

    public void deleteAnime(String id) {
        animeRepository.deleteAnimeById(id);
    }
}
