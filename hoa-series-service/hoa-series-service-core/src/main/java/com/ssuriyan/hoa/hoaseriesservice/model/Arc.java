package com.ssuriyan.hoa.hoaseriesservice.model;


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

    @Column(unique = true)
    private int arcNumber;

    private int firstEpisodeOfArc;

    private int lastEpisodeOfArc;

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

    public int getArcNumber() {
        return arcNumber;
    }

    public void setArcNumber(int arcNumber) {
        this.arcNumber = arcNumber;
    }

    public int getFirstEpisodeOfArc() {
        return firstEpisodeOfArc;
    }

    public void setFirstEpisodeOfArc(int firstEpisodeOfArc) {
        this.firstEpisodeOfArc = firstEpisodeOfArc;
    }

    public int getLastEpisodeOfArc() {
        return lastEpisodeOfArc;
    }

    public void setLastEpisodeOfArc(int lastEpisodeOfArc) {
        this.lastEpisodeOfArc = lastEpisodeOfArc;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }
}