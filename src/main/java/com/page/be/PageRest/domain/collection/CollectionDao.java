package com.page.be.PageRest.domain.collection;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.book.BookDataRepository;
import com.page.be.PageRest.domain.bookmark.Bookmark;

@Repository
@Transactional
public class CollectionDao {
	@Autowired
	CollectionDataRepository clnRepo;
	@Autowired
	BookDataRepository bookRepo;
	
	public Collection save(Collection cln) {
		clnRepo.save(cln);
		return cln;
	}
	
	public Collection selectById(Long cid) {
		return clnRepo.findById(cid).get();
	}
	
	public List<Collection> selectByIds(List<Long> cids) {
		return clnRepo.findByIdIn(cids);
	}
	
	public void updateBid(Long cid, Long bid) {
		Collection cln = clnRepo.findById(cid).get();
		Book book = bookRepo.findById(bid).get();
		
		cln.addBook(book);
		book.addCollection(cln);
		
		save(cln);
		bookRepo.save(book);
	}
	
	public void deleteById(Long cid) {
		clnRepo.deleteById(cid);
	}
	
	public void deleteBook(Long cid, Long bid) {
		Collection cln = clnRepo.findById(cid).get();
		Book book = bookRepo.findById(bid).get();
		cln.removeBook(book);
	}
	
	public List<Book> retrieveBooksById(Long cid) {
		Collection cln = clnRepo.findById(cid).get();
		return cln.getBooks();
	}
	
}
