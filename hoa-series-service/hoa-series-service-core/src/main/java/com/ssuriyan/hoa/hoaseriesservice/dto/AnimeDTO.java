package com.ssuriyan.hoa.hoaseriesservice.dto;

import com.ssuriyan.hoa.hoaseriesservice.model.Anime;

public class AnimeDTO {

    private RequestStatus requestStatus;

    private String id;

    private String name;

    private String mangaka;

    private String description;

    private int episodeCount;

    public AnimeDTO() {
    }

    public AnimeDTO(RequestStatus requestStatus, Anime anime) {
        this.requestStatus = requestStatus;
        this.id = anime.getId();
        this.name = anime.getName();
        this.mangaka = anime.getMangaka();
        this.description = anime.getDescription();
        this.episodeCount = anime.getEpisodeCount();
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
}
