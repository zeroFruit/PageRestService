package com.page.be.PageRest.domain.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.page.be.PageRest.domain.user.User;

public interface BookDataRepository extends JpaRepository<Book, Long> {
	List<Book> findByIdIn(List<Long> bids);
}
