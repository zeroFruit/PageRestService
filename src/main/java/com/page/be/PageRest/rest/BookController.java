package com.page.be.PageRest.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.book.BookDao;

@RestController
public class BookController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	BookDao bookDao;
	
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
}
