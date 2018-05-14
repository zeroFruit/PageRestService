package com.page.be.PageRest.domain.bookmark;

import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.tag_author.AuthorTag;
import com.page.be.PageRest.domain.tag_title.TitleTag;

import java.math.BigInteger;

public class RankDto {
    private Long athr;
    private Long tit;
    private AuthorTag author;
    private TitleTag title;
    private BigInteger bmcnt;

    public RankDto() {
    }

    public RankDto(Long athr, Long tit, BigInteger bmcnt) {
        this.athr = athr;
        this.tit = tit;
        this.bmcnt = bmcnt;
    }

    public Long getAthr() {
        return athr;
    }

    public void setAthr(Long athr) {
        this.athr = athr;
    }

    public Long getTit() {
        return tit;
    }

    public void setTit(Long tit) {
        this.tit = tit;
    }

    public AuthorTag getAuthor() {
        return author;
    }

    public void setAuthor(AuthorTag author) {
        this.author = author;
    }

    public TitleTag getTitle() {
        return title;
    }

    public void setTitle(TitleTag title) {
        this.title = title;
    }

    public BigInteger getBmcnt() {
        return bmcnt;
    }

    public void setBmcnt(BigInteger bmcnt) {
        this.bmcnt = bmcnt;
    }

    @Override
    public String toString() {
        return "RankDto{" +
                "athr=" + athr +
                ", tit=" + tit +
                ", author=" + author +
                ", title=" + title +
                ", bmcnt=" + bmcnt +
                '}';
    }
}
