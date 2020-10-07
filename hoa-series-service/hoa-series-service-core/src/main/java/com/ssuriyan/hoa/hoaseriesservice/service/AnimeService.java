package com.ssuriyan.hoa.hoaseriesservice.service;

import com.ssuriyan.hoa.hoaseriesservice.dto.AnimeDTO;
import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import com.ssuriyan.hoa.hoaseriesservice.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private ArcService arcService;

    public Anime insertAnime(Anime anime) {

        Anime savedAnime = null;
        if((savedAnime = animeRepository.findByName(anime.getName())) != null) {
            //Anime with same name already exists
            return savedAnime;
        }
        return animeRepository.save(anime);
    }

    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }

    public Anime getOne(String id) {
        return animeRepository.getOne(id);
    }

    public Anime saveAnime(Anime anime) {
        return animeRepository.save(anime);
    }

    public Anime updateAnime(Anime anime) {
        Anime savedAnime = animeRepository.getOne(anime.getId());
        if(savedAnime != null) {
            if(!anime.getName().isEmpty()) {
                savedAnime.setName(anime.getName());
            }
            /*if(!anime.getMangaka().isEmpty()) {
                savedAnime.setMangaka(anime.getMangaka());
            }*/
            if(anime.getManga() != null) {
                savedAnime.setManga(anime.getManga());
            }
            if(!anime.getDescription().isEmpty()) {
                savedAnime.setDescription(anime.getDescription());
            }
            return animeRepository.save(savedAnime);
         }
        return savedAnime;
    }

    public void deleteAnime(Anime anime) {
        arcService.deleteArcsByAnime(anime);
        animeRepository.deleteAnimeById(anime.getId());
    }

}