package com.page.be.PageRest.rest;

import java.util.List;

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
	
	@GetMapping("/bookmarks/user/{uid}")
	public List<Book> fetchBookmarksByUid(@PathVariable Long uid) {
		List<Book> books = bmDao.selectByUid(uid).getBooks();
		return books;
	}
}
