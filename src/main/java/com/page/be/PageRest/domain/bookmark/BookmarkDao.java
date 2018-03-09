package com.page.be.PageRest.domain.bookmark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public class BookmarkDao {
    @Autowired
    EntityManager em;
    @Autowired
    BookmarkDataRepository bmRepo;

    public void save(Bookmark bm) {
        bmRepo.save(bm);
    }
	
	public Bookmark selectByUid(Long uid) {
		return bmRepo.findByUserId(uid);
	}

	public BigInteger findBookmarkCount(Long bid) {
        Query query = em.createNativeQuery(
                "SELECT " +
                        " COUNT(*) AS cnt" +
                        " FROM bookmark_book" +
                        " WHERE book_id = :bid" +
                        " GROUP BY book_id");
        query.setParameter("bid", bid);
        try {
            return (BigInteger) query.getSingleResult();
        } catch (NoResultException e) {
            return BigInteger.valueOf(0L);
        }
    }

    public List<RankDto> findBookmarkRank() {
        Query query = em.createNativeQuery(
                "SELECT " +
                        " COUNT(*) AS bmcnt" +
                        " ,author_tag_id AS athr" +
                        " ,title_tag_id AS tit" +
                        " FROM bookmark_book" +
                        " INNER JOIN book" +
                        " ON bookmark_book.book_id = book.id" +
                        " GROUP BY athr, tit" +
                        " ORDER BY bmcnt DESC" +
                        " LIMIT 5", "BookmarkRankMapping");
        List<RankDto> ranks = query.getResultList();
        return ranks;
    }
}
