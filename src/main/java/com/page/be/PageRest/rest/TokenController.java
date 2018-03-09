package com.page.be.PageRest.rest;

import com.page.be.PageRest.domain.JwtUser;
import com.page.be.PageRest.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    private JwtGenerator gen;

    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser) {
        return gen.generate(jwtUser);
    }
}
