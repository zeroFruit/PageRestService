package com.page.be.PageRest.domain.tag_title;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.page.be.PageRest.PageRestApplication;
import com.page.be.PageRest.domain.tag_author.AuthorTag;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PageRestApplication.class)
public class TitleTagDaoTest {
	@Autowired
	TitleTagDao dao;
	@Autowired
	TitleTagDataRepository repo;
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	public void save_when_title_tag_exists() {
		String title = "Wonder";
		TitleTag titTag = dao.save(title);
		assertEquals(Long.valueOf(50001L), titTag.getId());
		assertEquals(4, repo.findAll().size());
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void save_when_title_tag_not_exists() {
		String title = "New Title";
		TitleTag titTag = dao.save(title);
		assertEquals(title, titTag.getTitle());
		assertEquals(5, repo.findAll().size());
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void updateAuthorTag_not_update() {
		AuthorTag athrTag = em.find(AuthorTag.class, 60001L);
		TitleTag titTag = em.find(TitleTag.class, 50001L);
		int num = titTag.getAuthorTags().size();
		dao.updateAuthorTag(athrTag, titTag);
		assertEquals(num, titTag.getAuthorTags().size());
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void updateAuthorTag_update() {
		AuthorTag athrTag = em.find(AuthorTag.class, 60001L);
		TitleTag titTag = new TitleTag("New Title Tag");
		int num = titTag.getAuthorTags().size();
		dao.updateAuthorTag(athrTag, titTag);
		assertEquals(num + 1, titTag.getAuthorTags().size());
	}
}
