package com.page.be.PageRest.domain.bookmark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import java.util.List;

public interface BookmarkDataRepository extends JpaRepository<Bookmark, Long> {
	Bookmark findByUserId(Long uid);
}
