package com.ssuriyan.hoa.hoaseriesservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "hoa_anime_episode")
public class Episode {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    @Column(unique = true)
    private int episodeNumber;

    private float duration;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_arc_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private SeriesArc seriesArc;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public SeriesArc getSeriesArc() {
        return seriesArc;
    }

    public void setSeriesArc(SeriesArc seriesArc) {
        this.seriesArc = seriesArc;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", episodeNumber=" + episodeNumber +
                ", duration=" + duration +
                ", type=" + type +
                ", arc=" + seriesArc +
                '}';
    }
}
