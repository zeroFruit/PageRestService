package com.page.be.PageRest.domain.tag_title;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.tag_author.AuthorTag;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
public class TitleTag {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String title;
	
	@OneToMany(mappedBy="titleTag")
	@JsonBackReference
	private List<Book> books = new ArrayList<>();
	@ManyToMany(mappedBy="titleTags")
	private List<AuthorTag> authorTags = new ArrayList<>();
	
	
	public TitleTag() {
	}
	public TitleTag(String title) {
		super();
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public List<AuthorTag> getAuthorTags() {
		return authorTags;
	}
	public void addAuthorTag(AuthorTag authorTag) {
		this.authorTags.add(authorTag);
	}
	@Override
	public String toString() {
		return "TitleTag [id=" + id + ", title=" + title + "]";
	}
	
}
