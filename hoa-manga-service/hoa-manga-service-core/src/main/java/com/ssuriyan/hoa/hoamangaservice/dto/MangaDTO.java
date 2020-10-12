package com.ssuriyan.hoa.hoamangaservice.dto;

import com.ssuriyan.hoa.hoamangaservice.model.Manga;

import java.util.ArrayList;
import java.util.List;

public class MangaDTO {

    private String id;

    private String name;

    private String description;

    private String mangaka;

    private String publisher;

    private int chapterCount;

    public MangaDTO() {
    }

    public MangaDTO(Manga manga) {
        if (manga!= null) {
            this.id = manga.getId();
            this.name = manga.getName();
            this.description = manga.getDescription();
            this.mangaka = manga.getMangaka();
            this.publisher = manga.getPublisher();
            this.chapterCount = manga.getChapterCount();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMangaka() {
        return mangaka;
    }

    public void setMangaka(String mangaka) {
        this.mangaka = mangaka;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getChapterCount() {
        return chapterCount;
    }

    public void setChapterCount(int chapterCount) {
        this.chapterCount = chapterCount;
    }

    public static List<MangaDTO> getMangaDTOList(List<Manga> mangaList) {
        List<MangaDTO> mangaDTOList = new ArrayList<>();
        for (Manga manga: mangaList) {
            mangaDTOList.add(new MangaDTO(manga));
        }
        return mangaDTOList;
    }
}
