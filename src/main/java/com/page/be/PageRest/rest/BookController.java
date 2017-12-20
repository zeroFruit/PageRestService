package com.page.be.PageRest.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
