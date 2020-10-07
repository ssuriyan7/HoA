package com.ssuriyan.hoa.hoaseriesservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ssuriyan.hoa.hoacommons.model.AbstractEntity;
import com.ssuriyan.hoa.hoamangaservice.model.Manga;

import javax.persistence.*;

@Entity
@Table(name = "hoa_anime")
public class Anime extends AbstractEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manga_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Manga manga;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int episodeCount;

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
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

}