package com.ecommerce.commons.security.jwt;

import com.ecommerce.commons.security.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtTokenWrapperService implements SecurityConstants {
    @Autowired
    private SecretKeyProvider secretKeyProvider;

    public JwtUser validateToken(String token){
        Jws<Claims> jws;
        try{
            jws = Jwts.parserBuilder()
                    .setSigningKey(secretKeyProvider.getSecretKey())
                    .build()
                    .parseClaimsJws(token);

            JwtUser user = new JwtUser();
            Claims body = jws.getBody();

            user.setPrincipal(body.getId());
            user.setFullName(body.getSubject());

            Object rawAuthorities = body.get(AUTHORITIES);
            if (rawAuthorities instanceof List<?>) {
                List<String> authorities = ((List<?>) rawAuthorities)
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.toList());

                user.setAuthorities(authorities);
            }

            return user;
        }catch (Exception e){
            return null;
        }
    }
}
