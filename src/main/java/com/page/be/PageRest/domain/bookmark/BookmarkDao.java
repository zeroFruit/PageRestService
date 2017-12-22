package com.page.be.PageRest.domain.bookmark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BookmarkDao {
	@Autowired
	BookmarkDataRepository bmRepo;
	
	public Bookmark selectByUid(Long uid) {
		return bmRepo.findByUserId(uid);
	}
}
