package com.page.be.PageRest.rest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.page.be.PageRest.domain.bookmark.BookmarkDao;
import com.page.be.PageRest.rest.response.BookResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.book.BookDao;
import com.page.be.PageRest.domain.book.BookDto;
import com.page.be.PageRest.domain.tag_author.AuthorTag;
import com.page.be.PageRest.domain.tag_author.AuthorTagDao;
import com.page.be.PageRest.domain.tag_title.TitleTag;
import com.page.be.PageRest.domain.tag_title.TitleTagDao;
import com.page.be.PageRest.domain.user.User;
import com.page.be.PageRest.domain.user.UserDao;

@RestController
public class BookController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BookDao bookDao;
    @Autowired
    BookmarkDao bmDao;
    @Autowired
    UserDao userDao;
    @Autowired
    AuthorTagDao authorTagDao;
    @Autowired
    TitleTagDao titleTagDao;

    @GetMapping("/books")
    public List<BookResponseDto> fetchBooks(
            @RequestParam("page") int page,
            @RequestParam("nof") int nof) {
        List<Book> books = bookDao.select(page * nof, nof);
        return setBookmarkCountsToBookResponseDto(books);
    }

    @GetMapping("/books/book")
    public List<BookResponseDto> fetchBooksByTagWithBid(
            @RequestParam("page") int page,
            @RequestParam("nof") int nof,
            @RequestParam("bid") Long bid) {
        Book b = bookDao.selectById(bid);
        List<Book> books = bookDao.selectByTag(
                b.getTitleTag().getId(),
                b.getAuthorTag().getId(), page * nof, nof);
        return setBookmarkCountsToBookResponseDto(books);
    }

    @GetMapping("/books/tag")
    public List<BookResponseDto> fetchBooksByTagWithTid(
            @RequestParam("page") int page,
            @RequestParam("nof") int nof,
            @RequestParam("athrid") Long athrid,
            @RequestParam("titid") Long titid) {
        List<Book> books = bookDao.selectByTag(titid, athrid, page * nof, nof);

        return setBookmarkCountsToBookResponseDto(books);
    }

    @GetMapping("/books/author_tag")
    public List<BookResponseDto> fetchBooksByAuthorTag(
            @RequestParam("page") int page,
            @RequestParam("nof") int nof,
            @RequestParam("bid") Long bid) {

        Book b = bookDao.selectById(bid);
        List<Book> books = bookDao.selectByAuthorTag(
                b.getAuthorTag().getId(), page * nof, nof);
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

    @GetMapping("/book/{bid}")
    public BookResponseDto fetchBook(@PathVariable Long bid) {
        Book book = bookDao.selectById(bid);
        BigInteger cnt = bmDao.findBookmarkCount(book.getId());
        return new BookResponseDto(book, cnt);
    }

    @GetMapping("/book/rank")
    public List<BookResponseDto> fetchBookRank() {
        int page = 0, nof = 5;
        List<Book> books = bookDao.select(page * nof, nof);
        return setBookmarkCountsToBookResponseDto(books);
    }

    @PostMapping("/book")
    public void insertBook(@RequestBody BookDto dto) {
        String imgSrc = dto.getImgSrc();
        String content = dto.getContent();
        String title = dto.getTitle();
        String author = dto.getAuthor();
        Long uid = dto.getUid();

        AuthorTag athrTag = authorTagDao.save(author);
        TitleTag titTag = titleTagDao.save(title);

        Book book = new Book(imgSrc, content);
        User user = userDao.findById(uid);
        book.setUser(user);
        book.setAuthorTag(athrTag);
        book.setTitleTag(titTag);
        bookDao.save(book);

        athrTag.addBook(book);
        titTag.addBook(book);

        authorTagDao.updateTitleTag(titTag, athrTag);
        titleTagDao.updateAuthorTag(athrTag, titTag);
    }

    @PutMapping("/book")
    public void updateBook(@RequestBody BookDto dto) {
        String title = dto.getTitle();
        String author = dto.getAuthor();
        Long id = dto.getId();

        AuthorTag athrTag = authorTagDao.save(author);
        TitleTag titTag = titleTagDao.save(title);
        dto.setAthrid(athrTag.getId());
        dto.setTitid(titTag.getId());

        bookDao.updateById(id, dto);

        authorTagDao.updateTitleTag(titTag, athrTag);
        titleTagDao.updateAuthorTag(athrTag, titTag);
    }

    @DeleteMapping("/book/{bid}")
    public void deleteBook(@PathVariable Long bid) {
        bookDao.deleteById(bid);
    }
}
