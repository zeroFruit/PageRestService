package com.page.be.PageRest.rest;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.page.be.PageRest.domain.tag.TagDto;
import com.page.be.PageRest.domain.tag_author.AuthorTagDao;
import com.page.be.PageRest.domain.tag_title.TitleTagDao;

@RestController
public class SearchController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	AuthorTagDao athrDao;
	@Autowired
	TitleTagDao titDao;
	
	@GetMapping("/search/tag")
	public List<TagDto> searchTag(@RequestParam String t) {
		List<TagDto> l1 = athrDao.findByAuthor(t);
		List<TagDto> l2 = titDao.findByTitle(t);
		return CollectionUtils.union(l1, l2).stream()
				.distinct()
				.collect(Collectors.toList());
	}
}
