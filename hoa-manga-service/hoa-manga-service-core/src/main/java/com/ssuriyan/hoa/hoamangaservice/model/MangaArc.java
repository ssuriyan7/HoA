package com.ssuriyan.hoa.hoamangaservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ssuriyan.hoa.hoacommons.model.AbstractEntity;
import com.ssuriyan.hoa.hoacommons.model.Arc;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "hoa_manga_arc")
public class MangaArc extends Arc {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manga_id")
    @JsonIgnoreProperties({"hibernateLazyInitial","handler"})
    private Manga manga;

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    @Override
    public String toString() {
        return "MangaArc{" +
                "manga=" + manga +
                '}';
    }
}
