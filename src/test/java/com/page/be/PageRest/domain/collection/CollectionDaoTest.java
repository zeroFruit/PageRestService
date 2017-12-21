package com.page.be.PageRest.domain.collection;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.page.be.PageRest.PageRestApplication;
import com.page.be.PageRest.domain.book.Book;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PageRestApplication.class)
public class CollectionDaoTest {
	@Autowired
	CollectionDao dao;
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	public void retrieveBookById_basic() {
		Long cid = 1L;
		List<Book> books = dao.retrieveBooksById(cid);
		assertEquals(2, books.size());
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void updateBid_basic() {
		Long cid = 1L;
		Long bid = 3L;
		dao.updateBid(cid, bid);
		Collection cln = em.find(Collection.class, cid);
		Book book = em.find(Book.class, bid);
		assertEquals(true, cln.getBooks().contains(book));
		assertEquals(true, book.getCollections().contains(cln));
		
	}

}
