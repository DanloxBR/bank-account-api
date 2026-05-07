package com.danieldev.api.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String gerarToken(String email) {
        Date agora = new Date();
        Date validade = new Date(agora.getTime() + expiration);
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(agora)
                .setExpiration(validade)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String obterEmail(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean tokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {

            return false;
        }
    }
}