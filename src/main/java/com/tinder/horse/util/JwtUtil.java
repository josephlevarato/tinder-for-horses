package com.tinder.horse.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.stereotype.Component;

import com.nimbusds.jose.jwk.source.ImmutableSecret;

@Component
public class JwtUtil {

    private final String secret;

    public JwtUtil(@Value("${jwt.secret}") String secret) {
        this.secret = secret;
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();

    }

    private NimbusJwtEncoder createToken(Map<String, Object> claims, String subject) {
        return new NimbusJwtEncoder(new ImmutableSecret<>(this.secret));
    }

}