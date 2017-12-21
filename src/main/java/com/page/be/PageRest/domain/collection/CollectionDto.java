package com.page.be.PageRest.domain.collection;

import java.util.List;

public class CollectionDto {
	private String label;
	private Long uid;
	private List<Long> bids;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public List<Long> getBids() {
		return bids;
	}
	public void setBids(List<Long> bids) {
		this.bids = bids;
	}
	@Override
	public String toString() {
		return "CollectionDto [label=" + label + ", bids=" + bids + "]";
	}
	
}
