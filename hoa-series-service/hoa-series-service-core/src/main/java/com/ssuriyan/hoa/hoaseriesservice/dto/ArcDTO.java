package com.ssuriyan.hoa.hoaseriesservice.dto;

import com.ssuriyan.hoa.hoaseriesservice.model.Arc;

import java.io.Serializable;

public class ArcDTO implements Serializable{

    private RequestStatus requestStatus;

    private String id;

    private String name;

    private int arcNumber;

    private int firstEpisodeOfArc;

    private int lastEpisodeOfArc;

    private String animeId;

    public ArcDTO() {
    }

    public ArcDTO(RequestStatus requestStatus, Arc arc) {
        this.requestStatus = requestStatus;
        this.id = arc.getId();
        this.name = arc.getName();
        this.arcNumber = arc.getArcNumber();
        this.firstEpisodeOfArc = arc.getFirstEpisodeOfArc();
        this.lastEpisodeOfArc = arc.getLastEpisodeOfArc();
        this.animeId = arc.getAnime().getId();
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

    public String getAnimeId() {
        return animeId;
    }

    public void setAnimeId(String animeId) {
        this.animeId = animeId;
    }
}
