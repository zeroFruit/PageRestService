package com.page.be.PageRest.domain.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<User, Long> {
	List<User> findByIdIn(List<Long> uids);
}
