package com.ssuriyan.hoa.hoaseriesservice.service;

import com.ssuriyan.hoa.hoaseriesservice.dto.AnimeDTO;
import com.ssuriyan.hoa.hoaseriesservice.dto.RequestStatus;
import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import com.ssuriyan.hoa.hoaseriesservice.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public AnimeDTO insertAnime(Anime anime) {
        RequestStatus requestStatus;
        Anime savedAnime = animeRepository.findByName(anime.getName());
        if(savedAnime != null && savedAnime.getName().equalsIgnoreCase(anime.getName())) {
            requestStatus = new RequestStatus(RequestStatus.Status.ERROR, "Anime already exists! :(");
        } else {
            savedAnime = animeRepository.save(anime);
            requestStatus = new RequestStatus(RequestStatus.Status.SUCCESS, "Insertion success! :)");
        }
        return new AnimeDTO(requestStatus, savedAnime);
    }

    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
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
