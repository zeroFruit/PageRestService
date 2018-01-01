package com.page.be.PageRest.domain.helloworld;

import org.springframework.web.multipart.MultipartFile;

public class MultiPartTest {
	private MultipartFile file;
	
	public MultiPartTest() {
	}
	public MultiPartTest(MultipartFile file) {
		super();
		this.file = file;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
