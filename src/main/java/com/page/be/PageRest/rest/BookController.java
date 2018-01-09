package com.page.be.PageRest.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	UserDao userDao;
	@Autowired
	AuthorTagDao authorTagDao;
	@Autowired
	TitleTagDao titleTagDao;
	
	@GetMapping("/books")
	public List<Book> fetchBooks(
			@RequestParam("page") int page,
			@RequestParam("nof") int nof) {
		return bookDao.select(page * nof, nof);
	}
	
	@GetMapping("/books/book")
	public List<Book> fetchBooksByTagWithBid(
			@RequestParam("page") int page,
			@RequestParam("nof") int nof,
			@RequestParam("bid") Long bid) {
		Book book = bookDao.selectById(bid);
		return bookDao.selectByTag(
				book.getTitleTag().getId(),
				book.getAuthorTag().getId(), page * nof, nof);
	}
	
	@GetMapping("/books/tag")
	public List<Book> fetchBooksByTagWithTid(
			@RequestParam("page") int page,
			@RequestParam("nof") int nof,
			@RequestParam("athrid") Long athrid,
			@RequestParam("titid") Long titid) {
		return bookDao.selectByTag(titid, athrid, page * nof, nof);
	}
	
	@GetMapping("/books/author_tag")
	public List<Book> fetchBooksByAuthorTag(
			@RequestParam("page") int page,
			@RequestParam("nof") int nof,
			@RequestParam("bid") Long bid) {
		Book book = bookDao.selectById(bid);
		return bookDao.selectByAuthorTag(
				book.getAuthorTag().getId(), page * nof, nof);
	}
	
	@GetMapping("/book/{bid}")
	public Book fetchBook(@PathVariable Long bid) {
		return bookDao.selectById(bid);
	}
	
	@PostMapping("/book")
	public void insertBook(@RequestBody BookDto dto) {
		String imgSrc = dto.getImgSrc();
		String content = dto.getContent();
		String title = dto.getTitle();
		String author = dto.getAuthor();
		
		AuthorTag athrTag = authorTagDao.save(author);
		TitleTag titTag = titleTagDao.save(title);
		
		Book book = new Book(imgSrc, content);
		User user = userDao.findById(dto.getUid());
		book.setUser(user);
		book.setAuthorTag(athrTag);
		book.setTitleTag(titTag);
		bookDao.save(book);
		
		athrTag.addBook(book);
		titTag.addBook(book);
	
		authorTagDao.updateTitleTag(titTag, athrTag);
		titleTagDao.updateAuthorTag(athrTag, titTag);
		
		return;
	}
}
