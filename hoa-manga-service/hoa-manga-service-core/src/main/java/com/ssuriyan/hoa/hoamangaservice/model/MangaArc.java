package com.ssuriyan.hoa.hoamangaservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "hoa_manga_arc")
public class MangaArc {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",  strategy = "uuid2")
    private String id;

    @Column(unique = true)
    private int arcNumber;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manga_id")
    @JsonIgnoreProperties({"hibernateLazyInitial","handler"})
    private Manga manga;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getArcNumber() {
        return arcNumber;
    }

    public void setArcNumber(int arcNumber) {
        this.arcNumber = arcNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    @Override
    public String toString() {
        return "MangaArc{" +
                "id='" + id + '\'' +
                ", arcNumber=" + arcNumber +
                ", name='" + name + '\'' +
                ", manga=" + manga +
                '}';
    }
}
