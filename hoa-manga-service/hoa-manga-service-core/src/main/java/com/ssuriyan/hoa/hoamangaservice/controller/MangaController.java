package com.ssuriyan.hoa.hoamangaservice.controller;

import com.ssuriyan.hoa.hoamangaservice.dto.MangaDTO;
import com.ssuriyan.hoa.hoamangaservice.model.Manga;
import com.ssuriyan.hoa.hoamangaservice.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "manga")
public class MangaController {

    @Autowired
    private MangaService mangaService;

    @PostMapping(value = "/add")
    public MangaDTO addManga(@RequestBody Manga manga) {
        return new MangaDTO(mangaService.addManga(manga));
    }

    @GetMapping(value = "/all")
    public List<MangaDTO> getAll() {
        return MangaDTO.getMangaDTOList(mangaService.getAll());
    }

    @PutMapping(value = "update")
    public MangaDTO updateManga(@RequestBody Manga manga) {
        return new MangaDTO(mangaService.addManga(manga));
    }
}
