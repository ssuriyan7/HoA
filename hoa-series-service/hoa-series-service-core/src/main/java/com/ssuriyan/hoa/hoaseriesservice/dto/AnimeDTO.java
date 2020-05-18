package com.ssuriyan.hoa.hoaseriesservice.dto;

import com.ssuriyan.hoa.hoaseriesservice.model.Anime;

import java.util.ArrayList;
import java.util.List;

public class AnimeDTO {

    private String id;

    private String name;

    private String mangaka;

    private String description;

    private int episodeCount;

    public AnimeDTO() {
    }

    public AnimeDTO(Anime anime) {
        this.id = anime.getId();
        this.name = anime.getName();
        this.mangaka = anime.getMangaka();
        this.description = anime.getDescription();
        this.episodeCount = anime.getEpisodeCount();
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

    public String getMangaka() {
        return mangaka;
    }

    public void setMangaka(String mangaka) {
        this.mangaka = mangaka;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    public static List<AnimeDTO> getAnimeDTOList(List<Anime> animeList) {
        List<AnimeDTO> animeDTOList = new ArrayList<>();
        for (Anime anime: animeList) {
            animeDTOList.add(new AnimeDTO(anime));
        }
        return animeDTOList;
    }
}
