package com.ssuriyan.hoa.hoaseriesservice.dto;

import com.ssuriyan.hoa.hoaseriesservice.model.Anime;

import java.util.ArrayList;
import java.util.List;

public class AnimeDTO {

    private String id;

    private String name;

    private String mangaId;

    private String description;

    private int episodeCount;

    public AnimeDTO() {
    }

    public AnimeDTO(Anime anime) {
        if(anime != null) {
            this.id = anime.getId();
            this.name = anime.getName();
            this.description = anime.getDescription();
            this.episodeCount = anime.getEpisodeCount();
            if (anime.getManga() != null) {
                this.mangaId = anime.getManga().getId();
            }
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

    public String getManga_id() {
        return mangaId;
    }

    public void setManga_id(String manga_id) {
        this.mangaId = manga_id;
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
