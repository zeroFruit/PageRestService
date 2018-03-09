package com.page.be.PageRest.domain.book;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.page.be.PageRest.domain.bookmark.Bookmark;
import com.page.be.PageRest.domain.bookmark.BookmarkDataRepository;
import com.page.be.PageRest.domain.collection.Collection;
import com.page.be.PageRest.domain.collection.CollectionDataRepository;
import com.page.be.PageRest.domain.tag_author.AuthorTag;
import com.page.be.PageRest.domain.tag_title.TitleTag;
import com.page.be.PageRest.domain.user.User;
import com.page.be.PageRest.domain.user.UserDataRepository;

@Repository
@Transactional
public class BookDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	@Autowired
	BookDataRepository bookRepo;
	@Autowired
	UserDataRepository userRepo;
	@Autowired
	CollectionDataRepository clnRepo;
	@Autowired
	BookmarkDataRepository bmRepo;
	
	public Book save(Book book) {
		bookRepo.save(book);
		return book;
	}
	
	public List<Book> select(int offset, int nof) {
		Query query = em.createNativeQuery(
				"select "
				+ " book.id"
				+ ", book.img_src"
				+ ", book.content"
				+ ", book.user_id"
				+ ", book.title_tag_id"
				+ ", book.author_tag_id"
				+ ", book.created_date"
				+ ", book.last_updated_date"
				+ ", user.display_name"
				+ " from book"
				+ " inner join user"
				+ " on book.user_id=user.id"
				+ " order by book.last_updated_date desc"
				+ " limit :nof"
				+ " offset :offset", Book.class);
		
		query.setParameter("offset", offset);
		query.setParameter("nof", nof);
		List<Book> books = query.getResultList();
		return books;
	}
	
	public List<Book> selectByTag(Long tid, Long aid, int offset, int nof) {
		Query query = em.createNativeQuery(
				"select "
				+ " book.id"
				+ ", book.img_src"
				+ ", book.content"
				+ ", book.user_id"
				+ ", book.title_tag_id"
				+ ", book.author_tag_id"
				+ ", book.created_date"
				+ ", book.last_updated_date"
				+ ", user.display_name"
				+ " from book"
				+ " inner join user"
				+ " on book.user_id=user.id"
				+ " where (book.title_tag_id=:tid and book.author_tag_id=:aid)"
				+ " order by book.last_updated_date desc"
				+ " limit :nof"
				+ " offset :offset", Book.class);
		query.setParameter("tid", tid);
		query.setParameter("aid", aid);
		query.setParameter("nof", nof);
		query.setParameter("offset", offset);
		List<Book> books = query.getResultList();
		return books;
	}
	
	public List<Book> selectByAuthorTag(Long aid, int offset, int nof) {
		Query query = em.createNativeQuery(
				"select "
				+ " book.id"
				+ ", book.img_src"
				+ ", book.content"
				+ ", book.user_id"
				+ ", book.title_tag_id"
				+ ", book.author_tag_id"
				+ ", book.created_date"
				+ ", book.last_updated_date"
				+ ", user.display_name"
				+ " from book"
				+ " inner join user"
				+ " on book.user_id=user.id"
				+ " where (book.author_tag_id=:aid)"
				+ " limit :nof"
				+ " offset :offset", Book.class);
		query.setParameter("aid", aid);
		query.setParameter("nof", nof);
		query.setParameter("offset", offset);
		List<Book> books = query.getResultList();
		return books;
	}
	
	public Book selectById(Long bid) {
		return bookRepo.findById(bid).get();
	}
	
	public List<Book> selectByIds(List<Long> bids) {
		return bookRepo.findByIdIn(bids);
	}
	
	public List<Book> selectByUid(Long uid) {
		User user = userRepo.findById(uid).get();
		return user.getBooks();
	}

	public Book updateBookmark(Long bid, Long bmid) {
		Book book = selectById(bid);
		Bookmark bm = bmRepo.findById(bmid).get();
		
		book.addBookmark(bm);
		bm.addBook(book);
		
		em.persist(book);
		em.persist(bm);
		return book;
	}
	
	public Book updateCollection(Long bid, Long cid) {
		Book book = selectById(bid);
		Collection cln = clnRepo.findById(cid).get();
		
		book.addCollection(cln);
		cln.addBook(book);
		
		em.persist(book);
		em.persist(cln);
		return book;
	}

	public void updateById(Long bid, BookDto dto) {
        String content = dto.getContent();
        Long athrid = dto.getAthrid();
        Long titid = dto.getTitid();

        Query query = em.createNativeQuery(
                "UPDATE book" +
                        " SET" +
                        "   book.content = :content" +
                        "   , book.author_tag_id = :athrid" +
                        "   , book.title_tag_id = :titid" +
                        " WHERE " +
                        "   id = :bid", Book.class);
        query.setParameter("content", content);
        query.setParameter("athrid", athrid);
        query.setParameter("titid", titid);
        query.setParameter("bid", bid);
        query.executeUpdate();
    }

	public void deleteById(Long bid) {
	    try {
            Book book = selectById(bid);
            Query query = em.createNativeQuery(
                    "DELETE " +
                            "FROM bookmark_book " +
                            "WHERE bookmark_book.book_id = :bid",
                    Bookmark.class);
            query.setParameter("bid", bid);
            query.executeUpdate();

            bookRepo.deleteById(bid);
        } catch (NoSuchElementException e) {
            return;
        }


    }

	public Book deleteFromBookmark(Long bid, Long bmid) {
		Book book = selectById(bid);
		Bookmark bm = bmRepo.findById(bmid).get();
		
		book.removeBookmark(bm);
		bm.removeBook(book);
		
		em.persist(book);
		em.persist(bm);
		return book;
	}
	
	public Book deleteFromCollection(Long bid, Long cid) {
		Book book = selectById(bid);
		Collection cln = clnRepo.findById(cid).get();
		book.removeCollection(cln);
		cln.removeBook(book);
		
		em.persist(book);
		em.persist(cln);
		return book;
	}
	
	public TitleTag retrieveTitleTag(Long bid) {
		Book book = selectById(bid);
		return book.getTitleTag();
	}
	
	public AuthorTag retrieveAuthorTag(Long bid) {
		Book book = selectById(bid);
		return book.getAuthorTag();
	}
}
