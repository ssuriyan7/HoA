package com.ssuriyan.hoa.hoamangaservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "hoa_manga")
public class Manga {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true)
    private String name;

    private String mangaka;

    private String publisher;

    private int chapterCount;

    private String description;

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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getChapterCount() {
        return chapterCount;
    }

    public void setChapterCount(int chapterCount) {
        this.chapterCount = chapterCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mangaka='" + mangaka + '\'' +
                ", publisher='" + publisher + '\'' +
                ", chapterCount=" + chapterCount +
                ", description='" + description + '\'' +
                '}';
    }
}
