package com.ssuriyan.hoa.hoamangaservice.service;

import com.ssuriyan.hoa.hoamangaservice.model.Manga;
import com.ssuriyan.hoa.hoamangaservice.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    public Manga addManga(Manga manga) {
        return mangaRepository.save(manga);
    }

    public List<Manga> getAll() {
        return mangaRepository.findAll();
    }
}
