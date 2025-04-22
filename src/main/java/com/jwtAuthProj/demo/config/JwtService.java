package com.jwtAuthProj.demo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtService {

    private static final String SECRET_KEY = "0MFgziXyFqLN3RMCCgcADU57fip4ihwPeqaARCVtBhOiZtBqlcthoL4nzI/oIZPWcbpTR1pk0rm51Hu7vi+CDASmTCYkC/ZTYkUoi4e6vI7eIBl/SsKwH6lcBMWIqvT/kVZOmyzik26lcRjOatBGxT05LkMHXnM9s4HEjPjeKTST1mFP89O3fOa6iMjyZmg3g/+97dSWMeOB03pDv5Iuxalu1rN8J/j+B04rmZhI996PeRvqk0RyINyhzqAGPQqi7VEjnZ5prRLjXDmRhU6KDjIGPMBvTJNGLmx5uFZQaTSwshMGILIsU+yCmUKT2+aCYLeBlUdQQYCaAzyi1fDaYRyU+3Y3mTiQGhIicCddXh8=";
    public String extractUsername(String token) {
        return null;
    }
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
