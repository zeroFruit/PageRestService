package com.page.be.PageRest.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.page.be.PageRest.domain.helloworld.Helloworld;
import com.page.be.PageRest.domain.helloworld.MultiPartTest;

@RestController
public class HelloworldController {
	Logger logger = LoggerFactory.getLogger(this.getClass()); 
			
	@GetMapping("/hello-world")
	public Helloworld helloWorld() {
		return new Helloworld("hello world");
	}
}
