package com.ssuriyan.hoa.hoaseriesservice.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animeId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    @Override
    public String toString() {
        return "Arc{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", arcNumber=" + arcNumber +
                ", anime=" + anime +
                '}';
    }
}