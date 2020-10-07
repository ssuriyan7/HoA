package com.ssuriyan.hoa.hoaseriesservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ssuriyan.hoa.hoacommons.model.AbstractEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "hoa_anime_episode")
public class Episode  extends AbstractEntity {

    @Column(unique = true)
    private int episodeNumber;

    private float duration;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_arc_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private SeriesArc seriesArc;

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
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
                "episodeNumber=" + episodeNumber +
                ", duration=" + duration +
                ", type=" + type +
                ", seriesArc=" + seriesArc +
                '}';
    }
}
