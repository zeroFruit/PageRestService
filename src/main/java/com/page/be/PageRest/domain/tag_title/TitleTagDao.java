package com.page.be.PageRest.domain.tag_title;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TitleTagDao {
	@Autowired
	TitleTagDataRepository titRepo;
	
	public TitleTag findById(Long titid) {
		return titRepo.findById(titid).get();
	}
}
