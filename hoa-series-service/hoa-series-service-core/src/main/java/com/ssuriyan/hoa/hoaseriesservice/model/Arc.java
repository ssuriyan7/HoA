package com.ssuriyan.hoa.services.series.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "hoa_anime_arc")
public class Arc {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private int startEpisode;

    private int endEpisode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animeId")
    private Anime anime;

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

    public int getStartEpisode() {
        return startEpisode;
    }

    public void setStartEpisode(int startEpisode) {
        this.startEpisode = startEpisode;
    }

    public int getEndEpisode() {
        return endEpisode;
    }

    public void setEndEpisode(int endEpisode) {
        this.endEpisode = endEpisode;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }
}
