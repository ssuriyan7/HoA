package com.ssuriyan.hoa.hoamangaservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ssuriyan.hoa.hoacommons.model.AbstractEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "hoa_chapter")
public class Chapter extends AbstractEntity {

    private int chapterNumber;

    private int pageCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manga_arc_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private MangaArc mangaArc;

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

    public MangaArc getMangaArc() {
        return mangaArc;
    }

    public void setMangaArc(MangaArc mangaArc) {
        this.mangaArc = mangaArc;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chapterNumber=" + chapterNumber +
                ", pageCount=" + pageCount +
                ", mangaArc=" + mangaArc +
                '}';
    }
}
