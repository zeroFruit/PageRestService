package com.page.be.PageRest.domain.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.bookmark.Bookmark;
import com.page.be.PageRest.domain.collection.Collection;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String displayName;
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@OneToMany(mappedBy="user")
	@JsonBackReference
	private List<Book> books = new ArrayList<>();
	@OneToMany(mappedBy="user")
	@JsonBackReference
	private List<Collection> collections = new ArrayList<>();
	@OneToOne(mappedBy="user")
	@JsonBackReference
	private Bookmark bookmark;
	
	public User() {
	}
	public User(String displayName) {
		super();
		this.displayName = displayName;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public Long getId() {
		return id;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void addBook(Book book) {
		this.books.add(book);
	}
	public void removeBook(Book book) {
		this.books.remove(book);
	}
	public List<Collection> getCollections() {
		return collections;
	}
	public void addCollection(Collection collection) {
		this.collections.add(collection);
	}
	public void removeCollection(Collection collection) {
		this.collections.remove(collection);
	}
	public Bookmark getBookmark() {
		return bookmark;
	}
	public void setBookmark(Bookmark bookmark) {
		this.bookmark = bookmark;
	}
	
}