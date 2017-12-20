package com.page.be.PageRest.domain.collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CollectionDao {
	@Autowired
	CollectionDataRepository clnRepo;
	
	public Collection save(Collection cln) {
		clnRepo.save(cln);
		return cln;
	}
	
	public Collection selectById(Long cid) {
		return clnRepo.findById(cid).get();
	}
	
	public List<Collection> selectByIds(List<Long> cids) {
		return clnRepo.findByIdIn(cids);
	}
	
	public void deleteById(Long cid) {
		clnRepo.deleteById(cid);
	}
	
}
