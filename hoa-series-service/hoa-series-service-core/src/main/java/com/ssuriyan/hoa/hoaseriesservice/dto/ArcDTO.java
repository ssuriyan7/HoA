package com.ssuriyan.hoa.hoaseriesservice.dto;

import com.ssuriyan.hoa.hoaseriesservice.model.SeriesArc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ArcDTO implements Serializable{

    private String id;

    private String name;

    private int arcNumber;

    private String animeId;

    public ArcDTO() {
    }

    public ArcDTO(SeriesArc seriesArc) {
        if (seriesArc != null) {
            this.id = seriesArc.getId();
            this.name = seriesArc.getName();
            this.arcNumber = seriesArc.getArcNumber();
            if (seriesArc.getAnime() != null) {
                this.animeId = seriesArc.getAnime().getId();
            }
        }
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

    public String getAnimeId() {
        return animeId;
    }

    public void setAnimeId(String animeId) {
        this.animeId = animeId;
    }

    public static List<ArcDTO> getArcDTOList(List<SeriesArc> seriesArcList) {
        List<ArcDTO> arcDTOList = new ArrayList<>();
        for (SeriesArc seriesArc : seriesArcList) {
            arcDTOList.add(new ArcDTO(seriesArc));
        }
        return arcDTOList;
    }
}
