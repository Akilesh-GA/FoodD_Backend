package com.example.app.Services;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    private SecretKey getSigninKey() {

        SecretKey key = Keys.hmacShaKeyFor(
                secretKey.getBytes(StandardCharsets.UTF_8)
        );
        
        return key;
    }

    public String generateToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                        new Date(System.currentTimeMillis() + expiration)
                )
                .signWith(getSigninKey())
                .compact();
    }

    public String extractEmail(String token) {

        Claims claims = Jwts.parser()
                            .verifyWith(getSigninKey())
                            .build()
                            .parseSignedClaims(token)
                            .getPayload();
        
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            
            Jwts.parser()
                .verifyWith(getSigninKey())
                .build()
                .parseSignedClaims(token);
            
            return true;
        } 
        catch(Exception exception) {
            return false;
        }
    }
}