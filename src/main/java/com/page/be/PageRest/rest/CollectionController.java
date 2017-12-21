package com.page.be.PageRest.rest;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.book.BookDao;
import com.page.be.PageRest.domain.collection.Collection;
import com.page.be.PageRest.domain.collection.CollectionDao;
import com.page.be.PageRest.domain.collection.CollectionDto;
import com.page.be.PageRest.domain.user.User;
import com.page.be.PageRest.domain.user.UserDao;

@RestController
public class CollectionController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CollectionDao clnDao;
	@Autowired
	UserDao userDao;
	@Autowired
	BookDao bookDao;

	@GetMapping("/collection/{cid}/books")
	public List<Book> fetchCollectionBooks(@PathVariable Long cid) {
		return clnDao.retrieveBooksById(cid);
	}
	
	@PostMapping("/collection")
	public void saveCollection(
			@RequestBody CollectionDto clnDto) {
		Collection cln = new Collection(clnDto.getLabel());
		User user = userDao.findById(clnDto.getUid());
		cln.setUser(user);
		for (Iterator<Long> it = clnDto.getBids().iterator(); it.hasNext();) {
			Long bid = (Long) it.next();
			Book book = bookDao.selectById(bid);
			cln.addBook(book);
		}
		clnDao.save(cln);
		return;
	}
	
	@DeleteMapping("/collection/{cid}")
	public void deleteCollection(@PathVariable Long cid) {
		clnDao.deleteById(cid);
	}
	
	@DeleteMapping("/collection/{cid}/book/{bid}")
	public void deleteCollectionBooks(
			@PathVariable Long cid,
			@PathVariable Long bid) {
		clnDao.deleteBook(cid, bid);
	}
	
	@PutMapping("/collection/{cid}/book/{bid}")
	public Book updateCollectionBooks(
			@PathVariable Long cid,
			@PathVariable Long bid) {
		clnDao.updateBid(cid, bid);
		return bookDao.selectById(bid);
	}
}
