package com.page.be.PageRest.domain.book;

public class BookDto {
	private Long id;
	private Long uid;
	private Long titid;
	private Long athrid;
	private String imgSrc;
	private String content;
	private String title;
	private String author;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getTitid() {
		return titid;
	}

	public void setTitid(Long titid) {
		this.titid = titid;
	}

	public Long getAthrid() {
		return athrid;
	}

	public void setAthrid(Long athrid) {
		this.athrid = athrid;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	
	
}
