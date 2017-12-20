package com.page.be.PageRest.domain.bookmark;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.page.be.PageRest.PageRestApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PageRestApplication.class)
public class BookmarkDaoTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	BookmarkDao dao;
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	public void selectByUid_basic() {
		Long uid = 1L;
		Bookmark bm = dao.selectByUid(uid);
		assertEquals(Long.valueOf(50001L), bm.getId());
		assertEquals(2, bm.getBooks().size());
	}

}
