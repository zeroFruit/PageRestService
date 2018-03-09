package com.page.be.PageRest.security;

import com.page.be.PageRest.domain.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {
    private String SESCRET_KEY = "THISISSECRET";

    public JwtUser validate(String token) {
        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(SESCRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            jwtUser = new JwtUser();
            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        } catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}
