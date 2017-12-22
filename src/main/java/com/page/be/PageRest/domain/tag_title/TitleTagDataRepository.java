package com.page.be.PageRest.domain.tag_title;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TitleTagDataRepository extends JpaRepository<TitleTag, Long>{
	@Query(value="select id"
			+ " , title"
			+ " from title_tag "
			+ " where lower(title) like lower('%'||:text ||'%')", nativeQuery=true)
	List<TitleTag> findTitleTagWithTextInTitle(@Param("text") String text);
	List<TitleTag> findByTitleContainingIgnoreCase(String title);
}
