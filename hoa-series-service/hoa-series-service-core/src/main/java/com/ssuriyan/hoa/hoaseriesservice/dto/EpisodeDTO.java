package com.ssuriyan.hoa.hoaseriesservice.dto;

import com.ssuriyan.hoa.hoaseriesservice.model.Arc;
import com.ssuriyan.hoa.hoaseriesservice.model.Episode;
import com.ssuriyan.hoa.hoaseriesservice.model.Type;

import java.util.ArrayList;
import java.util.List;

public class EpisodeDTO {

    private String id;

    private String name;

    private int episodeNumber;

    private float duration;

    private Type type;

    private String arcId;

    public EpisodeDTO() {
    }

    public EpisodeDTO(Episode episode) {
        this.id = episode.getId();
        this.name = episode.getName();
        this.episodeNumber = episode.getEpisodeNumber();
        this.duration = episode.getDuration();
        this.type = episode.getType();
        this.arcId = episode.getArc().getId();
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

    public String getArcId() {
        return arcId;
    }

    public void setArcId(String arcId) {
        this.arcId = arcId;
    }

    public static List<EpisodeDTO> getEpisodeDTOList(List<Episode> episodeList) {
        List<EpisodeDTO> episodeDTOList = new ArrayList<>();
        for (Episode episode: episodeList) {
            episodeDTOList.add(new EpisodeDTO(episode));
        }
        return episodeDTOList;
    }
}
