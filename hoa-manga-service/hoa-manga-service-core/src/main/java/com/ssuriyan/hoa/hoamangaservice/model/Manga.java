package com.ssuriyan.hoa.hoamangaservice.model;

import com.ssuriyan.hoa.hoacommons.model.AbstractEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "hoa_manga")
public class Manga extends AbstractEntity {

    private String mangaka;

    private String publisher;

    private int chapterCount;

    private String description;

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
                "mangaka='" + mangaka + '\'' +
                ", publisher='" + publisher + '\'' +
                ", chapterCount=" + chapterCount +
                ", description='" + description + '\'' +
                '}';
    }
}
