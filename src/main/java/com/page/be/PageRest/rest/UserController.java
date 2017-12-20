package com.page.be.PageRest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.user.UserDao;

@RestController
public class UserController {
	@Autowired
	UserDao userDao;
	
	@GetMapping("/user/{uid}")
	public List<Book> fetchUsers(@PathVariable Long uid) {
		return userDao.findById(uid).getBooks();
	}
}
