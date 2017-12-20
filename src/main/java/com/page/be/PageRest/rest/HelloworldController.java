package com.page.be.PageRest.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.page.be.PageRest.domain.helloworld.Helloworld;

@RestController
public class HelloworldController {
	@GetMapping("/hello-world")
	public Helloworld helloWorld() {
		return new Helloworld("hello world");
	}
}
