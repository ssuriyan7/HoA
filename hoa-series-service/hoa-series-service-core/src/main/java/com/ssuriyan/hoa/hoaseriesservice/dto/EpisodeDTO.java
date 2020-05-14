package com.ssuriyan.hoa.hoaseriesservice.dto;

import com.ssuriyan.hoa.hoaseriesservice.model.Arc;
import com.ssuriyan.hoa.hoaseriesservice.model.Episode;
import com.ssuriyan.hoa.hoaseriesservice.model.Type;

public class EpisodeDTO {

    private RequestStatus requestStatus;

    private String id;

    private String name;

    private int episodeNumber;

    private float duration;

    private Type type;

    private String arcId;

    public EpisodeDTO() {
    }

    public EpisodeDTO(RequestStatus requestStatus, Episode episode) {
        this.requestStatus = requestStatus;
        this.id = episode.getId();
        this.name = episode.getName();
        this.episodeNumber = episode.getEpisodeNumber();
        this.duration = episode.getDuration();
        this.type = episode.getType();
        this.arcId = episode.getArc().getId();
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
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
}
