package io.neko.springsecurityservice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TokenService {
    private String SIGNING_KEY = Stream.generate(() -> "myVerySecretKey").limit(100).collect(Collectors.joining());
    private long ACCESS_TOKEN_VALIDITY_SECONDS = 3600;
    private String ISSUER = "rest-service";


    public String generateToken(Authentication authentication) {
        return Jwts.builder()
            .setSubject(authentication.getName())
            .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS * 1000))
            .setId(UUID.randomUUID().toString())
            .setIssuer(ISSUER)
            .compact();
    }

    public String getUsername(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
            .setSigningKey(SIGNING_KEY)
            .parseClaimsJws(token)
            .getBody();
    }
}
