package com.page.be.PageRest.domain.tag_title;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.page.be.PageRest.domain.tag.TagDto;
import com.page.be.PageRest.domain.tag_author.AuthorTag;

@Repository
@Transactional
public class TitleTagDao {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	TitleTagDataRepository titRepo;
	
	public TitleTag findById(Long titid) {
		return titRepo.findById(titid).get();
	}
	
	public List<TagDto> findByTitle(String title) {
		List<TagDto> rt = new ArrayList<>();
		List<TitleTag> titleTags = titRepo.findByTitleContainingIgnoreCase(title);
		for (TitleTag _titleTag : titleTags) {
			List<AuthorTag> authorTags = _titleTag.getAuthorTags();
			logger.info("authorTags => {}", authorTags);
			for (AuthorTag _authorTag : authorTags) {
				TagDto dto = new TagDto();
				dto.setAuthorTag(_authorTag);
				dto.setTitleTag(_titleTag);
				rt.add(dto);
			}
		}
		return rt;
	}
}
