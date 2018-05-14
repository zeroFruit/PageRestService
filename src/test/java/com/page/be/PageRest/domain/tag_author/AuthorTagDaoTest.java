package com.page.be.PageRest.domain.tag_author;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.page.be.PageRest.PageRestApplication;
import com.page.be.PageRest.domain.tag_title.TitleTag;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PageRestApplication.class)
public class AuthorTagDaoTest {
	@Autowired
	AuthorTagDao dao;
	@Autowired
	AuthorTagDataRepository repo;
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	public void save_when_author_tag_exists() {
		String author = "R. J. Palacio";
		AuthorTag athrTag = dao.save(author);
		assertEquals(Long.valueOf(60001L), athrTag.getId());
		assertEquals(5, repo.findAll().size());
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void save_when_author_tag_not_exists() {
		String author = "New Author";
		AuthorTag athrTag = dao.save(author);
		assertEquals(author, athrTag.getAuthor());
		assertEquals(5, repo.findAll().size());
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void updateTitleTag_not_update() {
		AuthorTag athrTag = em.find(AuthorTag.class, 60001L);
		TitleTag titTag = em.find(TitleTag.class, 50001L);
		int num = athrTag.getTitleTags().size();
		dao.updateTitleTag(titTag, athrTag);
		assertEquals(num, athrTag.getTitleTags().size());
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void updateTitleTag_update() {
		AuthorTag athrTag = new AuthorTag("New Author Tag");
		TitleTag titTag = em.find(TitleTag.class, 50001L);
		int num = athrTag.getTitleTags().size();
		dao.updateTitleTag(titTag, athrTag);
		assertEquals(num + 1, athrTag.getTitleTags().size());
	}

}
