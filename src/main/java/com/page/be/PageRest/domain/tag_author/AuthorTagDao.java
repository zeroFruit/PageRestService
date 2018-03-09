package com.page.be.PageRest.domain.tag_author;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.page.be.PageRest.domain.tag.TagDto;
import com.page.be.PageRest.domain.tag_title.TitleTag;

@Repository
@Transactional
public class AuthorTagDao {
	@Autowired
	AuthorTagDataRepository athrRepo;
	
	public AuthorTag save(String author) {
		List<AuthorTag> authors = athrRepo.findByAuthor(author);
		if (authors.size() != 0) {
			return authors.get(0);
		}
		AuthorTag athrTag = new AuthorTag(author);
		athrRepo.save(athrTag);
		return athrTag;
	}

	public boolean isAuthorTagExist(String author) {
		return athrRepo.findByAuthor(author).size() != 0;
	}
	
	
	public AuthorTag findById(Long athrid) {
		return athrRepo.findById(athrid).get();
	}
	
	public List<TagDto> findByAuthor(String author) {
		List<TagDto> rt = new ArrayList<>();
		List<AuthorTag> authorTags = athrRepo.findByAuthorContainingIgnoreCase(author);
		for (AuthorTag _authorTag : authorTags) {
			List<TitleTag> titleTags = _authorTag.getTitleTags();
			for (TitleTag _titleTag : titleTags) {
				TagDto dto = new TagDto();
				dto.setAuthorTag(_authorTag);
				dto.setTitleTag(_titleTag);
				rt.add(dto);
			}
		}
		return rt;
	}
	
	public void updateTitleTag(TitleTag titTag, AuthorTag athrTag) {
		if(!athrTag.getTitleTags().contains(titTag)) {
			athrTag.addTitleTag(titTag);
		}
	}
}
