package com.ssuriyan.hoa.hoamangaservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "hoa_chapter")
public class Chapter {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true)
    private String name;

    private int chapterNumber;

    private int pageCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mangaId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Manga manga;

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

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", chapterNumber=" + chapterNumber +
                ", pageCount=" + pageCount +
                ", manga=" + manga +
                '}';
    }
}
