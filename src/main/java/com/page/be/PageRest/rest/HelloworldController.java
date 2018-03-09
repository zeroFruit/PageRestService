package com.page.be.PageRest.rest;

import com.page.be.PageRest.security.UserPasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.page.be.PageRest.domain.helloworld.Helloworld;
import com.page.be.PageRest.domain.helloworld.MultiPartTest;

@RestController
@RequestMapping("/hello")
public class HelloworldController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserPasswordEncoder encoder;

	@GetMapping
	public Helloworld helloWorld() {
		return new Helloworld("hello world");
	}

	@GetMapping("/hash/{id}")
	public String getHash(@PathVariable String id) {
		return encoder.encode(id);
	}
}
