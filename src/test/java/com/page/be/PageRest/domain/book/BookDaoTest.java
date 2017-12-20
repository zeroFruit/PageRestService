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
	@Autowired
	BookDao dao;
	@Autowired
	EntityManager em;
	
	@Test
	public void select_basic() {
		int offset = 0, nof = 3;
		List<Book> books = dao.select(offset, nof);
		assertEquals(3, books.size());
		assertEquals("content1", books.get(0).getContent());
		assertEquals("user1", books.get(0).getUser().getDisplayName());
	}
	
	@Test
	public void selectByTag_basic() {
		Long aid = 1L;
		Long tid = 1L;
		int page = 0;
		int nof = 3;
		List<Book> books = dao.selectByTag(tid, aid, page, nof);
		assertEquals(3, books.size());
	}
	
	@Test
	public void selectByAuthorTag_basic() {
		Long aid = 2L;
		int page = 0;
		int nof = 3;
		List<Book> books = dao.selectByAuthorTag(aid, page, nof);
		assertEquals(2, books.size());
	}
	
	@Test
	public void selectById_basic() {
		Long bid = 1L;
		Book book = dao.selectById(bid);
		assertEquals("content1", book.getContent());
		assertEquals("imgsrc://book1", book.getImgSrc());
	}
	
	@Test
	public void selectByIds_basic() {
		ArrayList<Long> bids = new ArrayList<>();
		bids.add(1L);
		bids.add(2L);
		List<Book> books = dao.selectByIds(bids);
		assertEquals(2, books.size());
		assertEquals("content1", books.get(0).getContent());
		assertEquals("content2", books.get(1).getContent());
	}
	
	@Test
	public void selectByUid_basic() {
		Long uid = 1L;
		List<Book> books = dao.selectByUid(uid);
		assertEquals(2, books.size());
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void updateBookmark_basic() {
		Long bid = 1L;
		Long bmid = 1L;
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
		Long bid = 1L;
		Long cid = 1L;
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
		Long bid = 1L;
		Long bmid = 1L;
		dao.updateBookmark(bid, bmid);
		dao.deleteFromBookmark(bid, bmid);
		
		Book book = em.find(Book.class, bid);
		Bookmark bm = em.find(Bookmark.class, bmid);
		assertEquals(false, book.getBookmarks().contains(bm));
		assertEquals(0, book.getBookmarks().size());
		
		assertEquals(false, bm.getBooks().contains(book));
		assertEquals(0, bm.getBooks().size());
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void deleteFromCollection_basic() {
		Long bid = 1L;
		Long cid = 1L;
		dao.updateCollection(bid, cid);
		dao.deleteFromCollection(bid, cid);
		
		Book book = em.find(Book.class, bid);
		Collection cln = em.find(Collection.class, cid);
		assertEquals(false, book.getCollections().contains(cln));
		assertEquals(0, book.getCollections().size());
		
		assertEquals(false, cln.getBooks().contains(book));
		assertEquals(0, cln.getBooks().size());
	}
	
	@Test
	public void retrieveTitleTag_basic() {
		Long bid = 1L;
		TitleTag titleTag = dao.retrieveTitleTag(bid);
		assertEquals(Long.valueOf(1L), titleTag.getId());
		assertEquals("title-tag-1", titleTag.getTitle());
	}
	
	@Test
	public void retrieveAuthorTag_basic() {
		Long bid = 1L;
		AuthorTag authorTag = dao.retrieveAuthorTag(bid);
		assertEquals(Long.valueOf(1L), authorTag.getId());
		assertEquals("author-1", authorTag.getAuthor());
	}
}
