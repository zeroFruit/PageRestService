package com.page.be.PageRest.domain.tag;

import com.page.be.PageRest.domain.tag_author.AuthorTag;
import com.page.be.PageRest.domain.tag_title.TitleTag;

public class TagDto {
	private AuthorTag authorTag;
	private TitleTag titleTag;
	public AuthorTag getAuthorTag() {
		return authorTag;
	}
	public void setAuthorTag(AuthorTag authorTag) {
		this.authorTag = authorTag;
	}
	public TitleTag getTitleTag() {
		return titleTag;
	}
	public void setTitleTag(TitleTag titleTag) {
		this.titleTag = titleTag;
	}
	@Override
	public String toString() {
		return "TagDto [authorTag=" + authorTag + ", titleTag=" + titleTag + "]";
	}
	
}
