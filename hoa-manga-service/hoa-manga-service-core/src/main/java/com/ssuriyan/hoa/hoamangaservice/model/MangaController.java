package com.ssuriyan.hoa.hoamangaservice.model;

import com.ssuriyan.hoa.hoamangaservice.dto.MangaDTO;
import com.ssuriyan.hoa.hoamangaservice.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/manga")
public class MangaController {

    @Autowired
    private MangaService mangaService;

    public MangaDTO addManga(@RequestBody Manga manga) {
        return new MangaDTO(mangaService.addManga(manga));
    }
}
