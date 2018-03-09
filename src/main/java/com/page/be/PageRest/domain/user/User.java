package com.page.be.PageRest.domain.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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

	@Column
	private String email;

	@Column(columnDefinition = "TEXT")
	private String profile;

	@Column
	private String pw;
	
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
	public User(String displayName, String email, String profile, String pw) {
		super();
		this.displayName = displayName;
		this.email = email;
		this.profile = profile;
		this.pw = pw;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", displayName='" + displayName + '\'' +
				", email='" + email + '\'' +
				", profile='" + profile + '\'' +
				'}';
	}
}