package com.page.be.PageRest.domain.user;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.bookmark.Bookmark;
import com.page.be.PageRest.domain.collection.Collection;

@Repository
@Transactional
public class UserDao {
	@Autowired
	EntityManager em;
	@Autowired
	UserDataRepository userRepo;
	
	public User save(User user) {
		userRepo.save(user);
		return user;
	}
	
	public User findById(Long uid) {
		return userRepo.findById(uid).get();
	}
	
	public List<User> findByIds(List<Long> uids) {
		return userRepo.findByIdIn(uids);
	}
	
	public Bookmark addBookmark(Long uid, Book book) {
		User user = findById(uid);
		Bookmark bm = user.getBookmark();
		bm.addBook(book);
		return bm;
	}
	
	public Bookmark removeBookmark(Long uid, Book book) {
		User user = findById(uid);
		Bookmark bm = user.getBookmark();
		bm.removeBook(book);
		return bm;
	}
	
	public List<Collection> retrieveCollections(Long uid) {
		User user = userRepo.findById(uid).get();
		return user.getCollections();
	}
	
	public List<Book> retrieveBooks(Long uid) {
		User user = userRepo.findById(uid).get();
		return user.getBooks();
	}
	
}
