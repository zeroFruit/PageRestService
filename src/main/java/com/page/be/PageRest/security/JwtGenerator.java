package com.page.be.PageRest.security;

import com.page.be.PageRest.domain.JwtUser;
import com.page.be.PageRest.domain.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {
    public String generate(JwtUser jwtUser) {
        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "THISISSECRET")
                .compact();
    }

    public String generateTokenForUser(User user) {
        Claims claims = Jwts.claims()
                .setSubject(user.getDisplayName());
        claims.put("id", user.getId());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "THISISSECRET")
                .compact();
    }
}
