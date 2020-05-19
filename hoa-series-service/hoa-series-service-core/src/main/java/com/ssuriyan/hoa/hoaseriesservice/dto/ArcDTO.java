package com.ssuriyan.hoa.hoaseriesservice.dto;

import com.ssuriyan.hoa.hoaseriesservice.model.Arc;

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

    public ArcDTO(Arc arc) {
        if (arc != null) {
            this.id = arc.getId();
            this.name = arc.getName();
            this.arcNumber = arc.getArcNumber();
            if (arc.getAnime() != null) {
                this.animeId = arc.getAnime().getId();
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

    public static List<ArcDTO> getArcDTOList(List<Arc> arcList) {
        List<ArcDTO> arcDTOList = new ArrayList<>();
        for (Arc arc: arcList) {
            arcDTOList.add(new ArcDTO(arc));
        }
        return arcDTOList;
    }
}
