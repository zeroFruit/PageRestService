package com.page.be.PageRest.utils;

import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.bookmark.BookmarkDao;
import com.page.be.PageRest.rest.response.BookResponseDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    @Autowired
    static BookmarkDao bmDao;

    static public BookResponseDto setBookmarkCountToBookResponseDto(Book book) {
        BigInteger cnt = bmDao.findBookmarkCount(book.getId());
        return new BookResponseDto(book, cnt);
    }
    static public List<BookResponseDto> setBookmarkCountsToBookResponseDto(List<Book> books) {
        List<BookResponseDto> res = new ArrayList<>();
        for (Book book : books) {
            BigInteger cnt = bmDao.findBookmarkCount(book.getId());
            BookResponseDto resDto = new BookResponseDto(book, cnt);
            res.add(resDto);
        }
        return res;
    }
}
