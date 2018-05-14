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

import java.math.BigInteger;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = PageRestApplication.class,
        properties = "spring.profiles.active=test")
public class BookmarkDaoTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BookmarkDao dao;
    @Autowired
    EntityManager em;

//	@Test
//	@Transactional
//	public void selectByUid_basic() {
//		Long uid = 10001L;
//		Bookmark bm = dao.selectByUid(uid);
//		assertEquals(Long.valueOf(30001L), bm.getId());
//		assertEquals(3, bm.getBooks().size());
//	}

    @Test
    @Transactional
    public void findBookmarkCount_basic() {
        Long bid = 20001L;
        BigInteger cnt = dao.findBookmarkCount(bid);
        System.out.println("test result >> " + cnt);
    }

    @Test
    @Transactional
    public void findBookmarkCount_no_result_test() {
        Long bid = 20011L;
        BigInteger cnt = dao.findBookmarkCount(bid);
        System.out.println("test result >> " + cnt);
    }

    @Test
    @Transactional
    @DirtiesContext
    public void findBookmarkRank_basic() {
        List<RankDto> ranks = dao.findBookmarkRank();
        for (RankDto rank: ranks) {
            System.out.println(rank);
        }
    }
}
