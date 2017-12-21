package com.page.be.PageRest.domain.book;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookQuery {
	@Autowired
	static EntityManager em;
	
	static Query selectQuery(int offset, int nof) {
		Query query = em.createNativeQuery(
				"select "
				+ " book.id"
				+ ", book.img_src"
				+ ", book.content"
				+ ", book.user_id"
				+ ", book.title_tag_id"
				+ ", book.author_tag_id"
				+ ", book.created_date"
				+ ", book.last_updated_date"
				+ ", user.display_name"
				+ " from book"
				+ " inner join user"
				+ " on book.user_id=user.id"
				+ " limit :nof"
				+ " offset :offset", Book.class);
		query.setParameter("offset", offset);
		query.setParameter("nof", nof);
		return query;
	}
}
