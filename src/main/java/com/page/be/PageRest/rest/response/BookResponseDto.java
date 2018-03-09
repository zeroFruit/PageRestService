package com.page.be.PageRest.rest.response;

import com.page.be.PageRest.domain.book.Book;

import java.math.BigInteger;

public class BookResponseDto {
    private Book book;
    private BigInteger bmcnt;
    public BookResponseDto(){}
    public BookResponseDto(Book book, BigInteger bmcnt) {
        this.book = book;
        this.bmcnt = bmcnt;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BigInteger getBmcnt() {
        return bmcnt;
    }

    public void setBmcnt(BigInteger bmcnt) {

        this.bmcnt = bmcnt;
    }
}
