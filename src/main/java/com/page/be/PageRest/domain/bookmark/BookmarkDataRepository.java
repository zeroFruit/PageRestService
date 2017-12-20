package com.page.be.PageRest.domain.bookmark;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkDataRepository extends JpaRepository<Bookmark, Long>{
	Bookmark findByUserId(Long uid);
}
