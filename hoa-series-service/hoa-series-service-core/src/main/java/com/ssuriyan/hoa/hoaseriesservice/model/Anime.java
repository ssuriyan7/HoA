package com.ssuriyan.hoa.hoaseriesservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "hoa_anime")
public class Anime {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true)
    private String name;

    private String mangaka;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int episodeCount;

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

    @Override
    public String toString() {
        return "Anime{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mangaka='" + mangaka + '\'' +
                ", description='" + description + '\'' +
                ", episodeCount=" + episodeCount +
                '}';
    }
}