package com.page.be.PageRest.domain.tag_author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AuthorTagDao {
	@Autowired
	AuthorTagDataRepository athrRepo;
	
	public AuthorTag findById(Long athrid) {
		return athrRepo.findById(athrid).get();
	}
}
