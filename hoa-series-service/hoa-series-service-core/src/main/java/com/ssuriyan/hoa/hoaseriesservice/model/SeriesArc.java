package com.ssuriyan.hoa.hoaseriesservice.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ssuriyan.hoa.hoacommons.model.Arc;

import javax.persistence.*;

@Entity
@Table(name = "hoa_series_arc")
public class SeriesArc extends Arc {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animeId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Anime anime;

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    @Override
    public String toString() {
        return "SeriesArc{" +
                "anime=" + anime +
                '}';
    }
}