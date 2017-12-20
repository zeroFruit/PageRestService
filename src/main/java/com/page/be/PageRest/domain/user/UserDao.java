package com.page.be.PageRest.domain.user;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDao {
	@Autowired
	EntityManager em;
	@Autowired
	UserDataRepository userRepo;
	
	public User findById(Long uid) {
		return userRepo.findById(uid).get();
	}
	
	public List<User> findByIds(List<Long> uids) {
		return userRepo.findByIdIn(uids);
	}
	
}
