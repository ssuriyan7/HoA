package com.ssuriyan.hoa.hoaseriesservice.controller;

import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import com.ssuriyan.hoa.hoaseriesservice.service.AnimeService;
import com.ssuriyan.hoa.hoaseriesservice.service.ArcService;
import com.ssuriyan.hoa.hoaseriesservice.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/anime")
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


}
