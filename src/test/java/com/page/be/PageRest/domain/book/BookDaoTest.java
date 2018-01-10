package com.page.be.PageRest.domain.book;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.page.be.PageRest.PageRestApplication;
import com.page.be.PageRest.domain.bookmark.Bookmark;
import com.page.be.PageRest.domain.collection.Collection;
import com.page.be.PageRest.domain.tag_author.AuthorTag;
import com.page.be.PageRest.domain.tag_title.TitleTag;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PageRestApplication.class)
public class BookDaoTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	BookDao dao;
	@Autowired
	EntityManager em;
	
	@Test
	public void select_basic() {
		int offset = 0, nof = 3;
		List<Book> books = dao.select(offset, nof);
		assertEquals(3, books.size());
		logger.info("{}", books);
	}
	
	@Test
	public void selectByTag_basic() {
		Long aid = 60001L;
		Long tid = 50001L;
		int page = 0;
		int nof = 3;
		List<Book> books = dao.selectByTag(tid, aid, page, nof);
		assertEquals(3, books.size());
		logger.info("{}", books);
	}
	
	@Test
	public void selectByAuthorTag_basic() {
		Long aid = 60002L;
		int page = 0;
		int nof = 3;
		List<Book> books = dao.selectByAuthorTag(aid, page, nof);
		assertEquals(2, books.size());
	}
	
	@Test
	public void selectById_basic() {
		Long bid = 20001L;
		Book book = dao.selectById(bid);
		assertEquals("content1", book.getContent());
		assertEquals(
			"https://cdn.pixabay.com/photo/2017/10/24/23/45/girl-2886598_150.jpg",
			book.getImgSrc());
	}
	
	@Test
	public void selectByIds_basic() {
		ArrayList<Long> bids = new ArrayList<>();
		bids.add(20001L);
		bids.add(20002L);
		List<Book> books = dao.selectByIds(bids);
		assertEquals(2, books.size());
		assertEquals("content1", books.get(0).getContent());
		assertEquals("content2", books.get(1).getContent());
	}
	
	@Test
	@Transactional
	public void selectByUid_basic() {
		Long uid = 10001L;
		List<Book> books = dao.selectByUid(uid);
		assertEquals(3, books.size());
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void updateBookmark_basic() {
		Long bid = 20001L;
		Long bmid = 30001L;
		dao.updateBookmark(bid, bmid);
		Book book = em.find(Book.class, bid);
		Bookmark bm = em.find(Bookmark.class, bmid);
		assertEquals(true, book.getBookmarks().contains(bm));
		assertEquals(true, bm.getBooks().contains(book));
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void updateCollection_basic() {
		Long bid = 20001L;
		Long cid = 40001L;
		dao.updateCollection(bid, cid);
		Book book = em.find(Book.class, bid);
		Collection cln = em.find(Collection.class, cid);
		assertEquals(true, book.getCollections().contains(cln));
		assertEquals(true, cln.getBooks().contains(book));
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void deleteFromBookmark_basic() {
		Long bid = 20001L;
		Long bmid = 30001L;
		dao.deleteFromBookmark(bid, bmid);
		
		Book book = em.find(Book.class, bid);
		Bookmark bm = em.find(Bookmark.class, bmid);
		assertEquals(false, book.getBookmarks().contains(bm));
		assertEquals(0, book.getBookmarks().size());
		
		assertEquals(false, bm.getBooks().contains(book));
		assertEquals(2, bm.getBooks().size());
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void deleteFromCollection_basic() {
		Long bid = 20001L;
		Long cid = 40001L;
		dao.deleteFromCollection(bid, cid);
		
		Book book = em.find(Book.class, bid);
		Collection cln = em.find(Collection.class, cid);
		assertEquals(false, book.getCollections().contains(cln));
		assertEquals(0, book.getCollections().size());
		
		assertEquals(false, cln.getBooks().contains(book));
		assertEquals(1, cln.getBooks().size());
	}
	
	@Test
	public void retrieveTitleTag_basic() {
		Long bid = 20001L;
		TitleTag titleTag = dao.retrieveTitleTag(bid);
		assertEquals(Long.valueOf(50001L), titleTag.getId());
		assertEquals("Wonder", titleTag.getTitle());
	}
	
	@Test
	public void retrieveAuthorTag_basic() {
		Long bid = 20001L;
		AuthorTag authorTag = dao.retrieveAuthorTag(bid);
		assertEquals(Long.valueOf(60001L), authorTag.getId());
		assertEquals("R. J. Palacio", authorTag.getAuthor());
	}
}
