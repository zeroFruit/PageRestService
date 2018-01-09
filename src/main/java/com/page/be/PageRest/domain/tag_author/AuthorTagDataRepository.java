package com.page.be.PageRest.domain.tag_author;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorTagDataRepository extends JpaRepository<AuthorTag, Long>{
	@Query(value="select id"
			+ " , author"
			+ " from author_tag "
			+ " where lower(author) like lower('%' || :text || '%')", nativeQuery=true)
	List<AuthorTag> findAuthorTagWithTextInAuthor(@Param("text") String text);
	List<AuthorTag> findByAuthorContainingIgnoreCase(String author);
	List<AuthorTag> findByAuthor(String author);
}
