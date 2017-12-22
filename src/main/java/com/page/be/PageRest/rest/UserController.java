package com.page.be.PageRest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.book.BookDao;
import com.page.be.PageRest.domain.bookmark.Bookmark;
import com.page.be.PageRest.domain.collection.Collection;
import com.page.be.PageRest.domain.user.User;
import com.page.be.PageRest.domain.user.UserDao;

@RestController
public class UserController {
	@Autowired
	UserDao userDao;
	@Autowired
	BookDao bookDao;
	
	@GetMapping("/user/{uid}")
	public User fetchUsers(@PathVariable Long uid) {
		return userDao.findById(uid);
	}
	
	@GetMapping("/user/{uid}/collections")
	public List<Collection> fetchCollections(@PathVariable Long uid) {
		return userDao.retrieveCollections(uid);
	}
	
	@GetMapping("/user/{uid}/books")
	public List<Book> fetchBooks(@PathVariable Long uid) {
		return userDao.retrieveBooks(uid);
	}
	
	@PutMapping("/user/{uid}/bookmark/{bid}")
	public Bookmark addBookmark(
			@PathVariable Long uid,
			@PathVariable Long bid) {
		Book book = bookDao.selectById(bid);
		return userDao.addBookmark(uid, book);
	}

	@DeleteMapping("/user/{uid}/bookmark/{bid}")
	public Bookmark removeBookmark(
			@PathVariable Long uid,
			@PathVariable Long bid) {
		Book book = bookDao.selectById(bid);
		return userDao.removeBookmark(uid, book);
	}
}
