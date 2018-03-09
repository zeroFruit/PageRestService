package com.page.be.PageRest.rest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.page.be.PageRest.domain.book.BookDao;
import com.page.be.PageRest.domain.bookmark.RankDto;
import com.page.be.PageRest.domain.tag_author.AuthorTag;
import com.page.be.PageRest.domain.tag_author.AuthorTagDao;
import com.page.be.PageRest.domain.tag_title.TitleTag;
import com.page.be.PageRest.domain.tag_title.TitleTagDao;
import com.page.be.PageRest.rest.response.BookResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.bookmark.BookmarkDao;

@RestController
public class BookmarkController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BookmarkDao bmDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorTagDao athrDao;
    @Autowired
    private TitleTagDao titDao;

    @GetMapping("/bookmarks/user/{uid}")
    public List<BookResponseDto> fetchBookmarksByUid(@PathVariable Long uid) {
        List<Book> books = bmDao.selectByUid(uid).getBooks();
        return setBookmarkCountsToBookResponseDto(books);
    }

    private List<BookResponseDto> setBookmarkCountsToBookResponseDto(List<Book> books) {
        List<BookResponseDto> res = new ArrayList<>();
        for (Book book : books) {
            BigInteger cnt = bmDao.findBookmarkCount(book.getId());
            BookResponseDto resDto = new BookResponseDto(book, cnt);
            res.add(resDto);
        }
        return res;
    }

    @GetMapping("/bookmarks/rank")
    public List<RankDto> fetchBookmarkRanking() {
        return bmDao.findBookmarkRank().stream().map(rank -> {
            AuthorTag athr = athrDao.findById(rank.getAthr());
            TitleTag tit = titDao.findById(rank.getTit());

            rank.setAuthor(athr);
            rank.setTitle(tit);
            return rank;
        }).collect(Collectors.toList());
    }

}
