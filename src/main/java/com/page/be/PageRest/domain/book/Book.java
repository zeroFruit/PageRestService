package com.page.be.PageRest.domain.book;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.page.be.PageRest.domain.bookmark.Bookmark;
import com.page.be.PageRest.domain.collection.Collection;
import com.page.be.PageRest.domain.tag_author.AuthorTag;
import com.page.be.PageRest.domain.tag_title.TitleTag;
import com.page.be.PageRest.domain.user.User;

@SqlResultSetMapping(
        name = "RecentCreatedBookMapping",
        entities = {
                @EntityResult(
                        entityClass = Book.class,
                        fields = {
                                @FieldResult(name="created_date", column="created_date"),
                        }),
                @EntityResult(
                        entityClass = TitleTag.class,
                        fields = {
                                @FieldResult(name="id", column="titid"),
                                @FieldResult(name="title", column="title")
                        }),
                @EntityResult(
                        entityClass = AuthorTag.class,
                        fields = {
                                @FieldResult(name="id", column="athrid"),
                                @FieldResult(name="author", column="author")
                        })
        }
)
@Entity
public class Book implements Comparable<Book> {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String imgSrc;

	@Lob
	@Column
	private String content;
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	@CreationTimestamp
	private LocalDateTime createdDate;

	@ManyToOne
	@JsonManagedReference
	private User user;
	@ManyToOne
	@JsonBackReference
	private TitleTag titleTag;
	@ManyToOne
	@JsonBackReference
	private AuthorTag authorTag;
	@ManyToMany
	private List<Bookmark> bookmarks = new ArrayList<>();
	@ManyToMany
	@JsonBackReference
	private List<Collection> collections = new ArrayList<>();

	public Book() {
	}

	public Book(String imgSrc, String content) {
		super();
		this.imgSrc = imgSrc;
		this.content = content;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public TitleTag getTitleTag() {
		return titleTag;
	}

	public void setTitleTag(TitleTag titleTag) {
		this.titleTag = titleTag;
	}

	public AuthorTag getAuthorTag() {
		return authorTag;
	}

	public void setAuthorTag(AuthorTag authorTag) {
		this.authorTag = authorTag;
	}

	public List<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public void addBookmark(Bookmark bookmark) {
		this.bookmarks.add(bookmark);
	}

	public void removeBookmark(Bookmark bookmark) {
		this.bookmarks.remove(bookmark);
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", content=" + content + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Book)) return false;
		return (this.imgSrc == ((Book) o).getImgSrc());
	}

	@Override
	public int compareTo(Book o) {
		return o.getCreatedDate().compareTo(getCreatedDate());
	}
}