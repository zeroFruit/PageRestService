package com.page.be.PageRest.domain.bookmark;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.user.User;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
public class Bookmark {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private User user;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="BOOKMARK_BOOK",
		joinColumns=@JoinColumn(name="BOOKMARK_ID"),
		inverseJoinColumns=@JoinColumn(name="BOOK_ID")
	)
	private List<Book> books = new ArrayList<>();
	
	public Bookmark() {
		super();
	}

	public Long getId() {
		return id;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Book> getBooks() {
		return books;
	}
	public void addBook(Book book) {
		this.books.add(book);
		this.books.sort((Book b1, Book b2) -> b1.getId().compareTo(b2.getId()));
	}
	public void removeBook(Book book) {
		this.books.remove(book);
		this.books.sort((Book b1, Book b2) -> b1.getId().compareTo(b2.getId()));
	}
	@Override
	public String toString() {
		return "Bookmark [id=" + id + "]" + "[books=" + books + "]";
	}
	
	
}
