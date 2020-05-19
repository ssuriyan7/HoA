package com.ssuriyan.hoa.hoaseriesservice.controller;

import com.ssuriyan.hoa.hoaseriesservice.dto.AnimeDTO;
import com.ssuriyan.hoa.hoaseriesservice.dto.ArcDTO;
import com.ssuriyan.hoa.hoaseriesservice.dto.EpisodeDTO;
import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import com.ssuriyan.hoa.hoaseriesservice.model.Arc;
import com.ssuriyan.hoa.hoaseriesservice.model.Episode;
import com.ssuriyan.hoa.hoaseriesservice.service.AnimeService;
import com.ssuriyan.hoa.hoaseriesservice.service.ArcService;
import com.ssuriyan.hoa.hoaseriesservice.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeriesController {

    @Autowired
    private AnimeService animeService;

    @Autowired
    private ArcService arcService;

    @Autowired
    private EpisodeService episodeService;

    @PostMapping(value = "/add/anime")
    public AnimeDTO addAnime(@RequestBody Anime anime) {
        return new AnimeDTO(animeService.insertAnime(anime));
    }

    @PostMapping(value = "/add/arc")
    public ArcDTO addArc(@RequestBody Arc arc) {
        return new ArcDTO(arcService.insertArc(arc));
    }

    @PostMapping(value = "/add/episode")
    public EpisodeDTO addEpisode(@RequestBody Episode episode) {
        return new EpisodeDTO(episodeService.insertEpisode(episode));
    }

    @GetMapping(value = "/get/animes")
    public List<AnimeDTO> getAllAnime() {
        return AnimeDTO.getAnimeDTOList(animeService.getAllAnime());
    }

    @GetMapping(value = "/get/arcs")
    public List<ArcDTO> getArcsByAnime(@RequestBody Anime anime) {
        return ArcDTO.getArcDTOList(arcService.getArcsByAnime(anime));
    }

    @GetMapping(value = "/get/episodes")
    public List<EpisodeDTO > getEpisodesByArc(@RequestBody Arc arc) {
        return EpisodeDTO.getEpisodeDTOList(episodeService.getEpisodesByArc(arc));
    }

    @GetMapping(value = "/get/anime")
    public AnimeDTO getAnime(@RequestParam String animeId) {
        return new AnimeDTO(animeService.getOne(animeId));
    }

    @GetMapping(value = "/get/arc")
    public ArcDTO getArc(@RequestParam String arcId) {
        return new ArcDTO(arcService.getOne(arcId));
    }

    @GetMapping(value = "/get/episode")
    public EpisodeDTO getEpisode(@RequestParam String episodeId) {
        return new EpisodeDTO(episodeService.getOne(episodeId));
    }

    @PutMapping(value = "/update/anime")
    public AnimeDTO updateAnime(@RequestBody Anime anime) {
        return new AnimeDTO(animeService.updateAnime(anime));
    }

    @PutMapping(value = "/update/arc")
    public ArcDTO updateArc(@RequestBody Arc arc) {
        return new ArcDTO(arcService.updateArc(arc));
    }

    @PutMapping(value = "/update/episode")
    public EpisodeDTO updateEpisode(@RequestBody Episode episode) {
        return new EpisodeDTO(episodeService.updateEpisode(episode));
    }

}