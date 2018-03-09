package com.page.be.PageRest.domain.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.page.be.PageRest.domain.tag_title.TitleTag;

public interface UserDataRepository extends JpaRepository<User, Long> {
	List<User> findByIdIn(List<Long> uids);
    Optional<User> findByEmail(String email);
}
