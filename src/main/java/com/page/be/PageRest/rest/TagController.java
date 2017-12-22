package com.page.be.PageRest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.book.BookDao;
import com.page.be.PageRest.domain.tag.TagDto;
import com.page.be.PageRest.domain.tag_author.AuthorTag;
import com.page.be.PageRest.domain.tag_author.AuthorTagDao;
import com.page.be.PageRest.domain.tag_title.TitleTag;
import com.page.be.PageRest.domain.tag_title.TitleTagDao;

@RestController
public class TagController {
	@Autowired
	BookDao bookDao;
	@Autowired
	AuthorTagDao athrDao;
	@Autowired
	TitleTagDao titDao;
	
	@GetMapping("/tag/book/{bid}")
	public TagDto fetchTagByBid(@PathVariable Long bid) {
		TagDto tagDto = new TagDto();
		Book book = bookDao.selectById(bid);
		
		AuthorTag athrTag = book.getAuthorTag();
		TitleTag titTag = book.getTitleTag();
		tagDto.setAuthorTag(athrTag);
		tagDto.setTitleTag(titTag);
		return tagDto;
	}
	
	@GetMapping("/tag/{athrid}/{titid}")
	public TagDto fetchTag(
			@PathVariable Long athrid,
			@PathVariable Long titid) {
		TagDto tagDto = new TagDto();
		AuthorTag athrTag = athrDao.findById(athrid);
		TitleTag titTag = titDao.findById(titid);
		tagDto.setAuthorTag(athrTag);
		tagDto.setTitleTag(titTag);
		return tagDto;
	}
}
