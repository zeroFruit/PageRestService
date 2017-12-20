package com.page.be.PageRest.domain.tag_author;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.tag_title.TitleTag;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
public class AuthorTag {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String author;
	
	@OneToMany(mappedBy="authorTag")
	@JsonManagedReference
	private List<Book> books = new ArrayList<>();
	@ManyToMany
	private List<TitleTag> titleTags = new ArrayList<>();
	
	public AuthorTag() {
	}
	public AuthorTag(String author) {
		super();
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public List<TitleTag> getTitleTags() {
		return titleTags;
	}
	public void addTitleTag(TitleTag titleTag) {
		this.titleTags.add(titleTag);
	}
	public void removeTitleTag(TitleTag titleTag) {
		this.titleTags.remove(titleTag);
	}
	@Override
	public String toString() {
		return "AuthorTag [id=" + id + ", author=" + author + "]";
	}
	
}
