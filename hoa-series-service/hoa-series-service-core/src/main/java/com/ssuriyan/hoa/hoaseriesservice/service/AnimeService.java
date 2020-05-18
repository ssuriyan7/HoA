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

    public ResponseEntity<AnimeDTO> insertAnime(Anime anime) {
        /*RequestStatus requestStatus;
        Anime savedAnime = animeRepository.findByName(anime.getName());
        if(savedAnime != null && savedAnime.getName().equalsIgnoreCase(anime.getName())) {
            requestStatus = new RequestStatus(RequestStatus.Status.ERROR, "Anime already exists! :(");
        } else {
            savedAnime = animeRepository.save(anime);
            requestStatus = new RequestStatus(RequestStatus.Status.SUCCESS, "Insertion success! :)");
        }
        return new AnimeDTO(requestStatus, savedAnime);*/

        Anime savedAnime = null;
        if((savedAnime = animeRepository.findByName(anime.getName())) != null) {
            return ResponseEntity.badRequest()
                    .header("Message", "Anime already exists! :(")
                    .body(new AnimeDTO(savedAnime));
        }
        savedAnime = animeRepository.save(anime);
        return ResponseEntity.accepted()
                .header("Message", "Insertion Success")
                .body(new AnimeDTO(savedAnime));
    }

    public ResponseEntity<List<AnimeDTO>> getAllAnime() {
//        return animeRepository.findAll();
        return ResponseEntity.ok()
                .body(AnimeDTO.getAnimeDTOList(animeRepository.findAll()));
    }

    public Anime getOne(String id) {
        return animeRepository.getOne(id);
    }

    public Anime updateAnime(Anime anime) {
        return animeRepository.save(anime);
    }

    public void deleteAnime(String id) {
        animeRepository.deleteAnimeById(id);
    }
}
