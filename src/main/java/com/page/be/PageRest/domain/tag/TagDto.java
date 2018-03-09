package com.page.be.PageRest.domain.tag;

import com.page.be.PageRest.domain.tag_author.AuthorTag;
import com.page.be.PageRest.domain.tag_title.TitleTag;
import io.jsonwebtoken.lang.Strings;

import java.util.Arrays;
import java.util.HashMap;

public class TagDto implements Comparable {
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

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TagDto)) {
			return false;
		}
		TagDto o = (TagDto) obj;
		return (
				this.authorTag.getId() == o.getAuthorTag().getId() &&
						this.titleTag.getId() == o.getTitleTag().getId()
		);
	}

	@Override
	public int compareTo(Object o) {
		TagDto tag = (TagDto) o;
		Long[] arr1 = {this.authorTag.getId(), this.titleTag.getId()};
		Long[] arr2 = {tag.getAuthorTag().getId(), tag.getTitleTag().getId()};
		return Strings.arrayToCommaDelimitedString(arr1).compareTo(Strings.arrayToCommaDelimitedString(arr2));

	}
}
