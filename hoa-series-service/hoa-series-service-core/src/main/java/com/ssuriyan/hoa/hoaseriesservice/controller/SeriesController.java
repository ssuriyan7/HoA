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

    @GetMapping(value = "/all")
    public List<Anime> getAllAnime() {
        return animeService.getAllAnime();
    }

    @PostMapping(value = "/add/anime")
    public AnimeDTO addAnime(@RequestBody Anime anime) {
        return animeService.insertAnime(anime);
    }

    @PostMapping(value = "/add/arc")
    public ArcDTO addArc(@RequestBody Arc arc) {
        return arcService.insertArc(arc);
    }

    @PostMapping(value = "/add/episode")
    public EpisodeDTO addEpisode(@RequestBody Episode episode) {
        return episodeService.insertEpisode(episode);
    }

    @GetMapping(value = "/get/arcs")
    public List<Arc> getArcsByAnime(@RequestBody Anime anime) {
        return arcService.getArcsByAnime(anime);
    }

    @GetMapping(value = "/get/episodes")
    public List<Episode> getEpisodesByArc(@RequestBody Arc arc) {
        return episodeService.getEpisodesByArc(arc);
    }
}