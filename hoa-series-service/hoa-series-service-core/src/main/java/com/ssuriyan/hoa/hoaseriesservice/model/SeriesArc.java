package com.ssuriyan.hoa.hoaseriesservice.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ssuriyan.hoa.hoacommons.model.AbstractEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "hoa_series_arc")
public class SeriesArc extends AbstractEntity {

    @Column(unique = true)
    private int arcNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animeId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Anime anime;

    public int getArcNumber() {
        return arcNumber;
    }

    public void setArcNumber(int arcNumber) {
        this.arcNumber = arcNumber;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    @Override
    public String toString() {
        return "SeriesArc{" +
                "arcNumber=" + arcNumber +
                ", anime=" + anime +
                '}';
    }
}