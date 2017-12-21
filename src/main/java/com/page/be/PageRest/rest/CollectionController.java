package com.page.be.PageRest.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.collection.Collection;
import com.page.be.PageRest.domain.collection.CollectionDao;

@RestController
public class CollectionController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CollectionDao clnDao;

	@GetMapping("/collection/{cid}/books")
	public List<Book> fetchCollectionBooks(@PathVariable Long cid) {
		return clnDao.retrieveBooksById(cid);
	}
	
	@PutMapping("/collection/{cid}/book/{bid}")
	public Collection updateCollectionBooks(
			@PathVariable Long cid,
			@PathVariable Long bid) {
		logger.info("cid => {}, bid => {}", cid, bid);
		clnDao.updateBid(cid, bid);
		return clnDao.selectById(cid);
	}
}
