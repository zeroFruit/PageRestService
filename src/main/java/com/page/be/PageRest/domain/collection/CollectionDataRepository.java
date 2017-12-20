package com.page.be.PageRest.domain.collection;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionDataRepository extends JpaRepository<Collection, Long> {
	List<Collection> findByIdIn(List<Long> cids);
}
