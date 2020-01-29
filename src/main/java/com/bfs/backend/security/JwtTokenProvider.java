package com.bfs.backend.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {
    @Value("${security.jwt.token.secret-key:secret}")
    private String secretKey = "secret";
    @Value("${security.jwt.token.expire-length:3600000}")
    private long validityInMilliseconds = 3600000L;

    @Qualifier("userServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    public JwtTokenProvider() {
    }

    @PostConstruct
    protected void init() {
        this.secretKey = Base64.getEncoder().encodeToString(this.secretKey.getBytes());
    }

    public String createToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);
//        claims.put("roles", roles);
        Date now = new Date();
        Date validity = new Date(now.getTime() + this.validityInMilliseconds);
        return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity).signWith(SignatureAlgorithm.HS256, this.secretKey).compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(this.getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        return ((Claims)Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody()).getSubject();
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        return bearerToken != null && bearerToken.startsWith("Bearer ") ? bearerToken.substring(7) : null;
    }

//    public boolean validateToken(String token) {
//        try {
//            Jws<Claims> claims = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token);
//            return !((Claims)claims.getBody()).getExpiration().before(new Date());
//        } catch (IllegalArgumentException | JwtException var3) {
//            throw new InvalidJwtAuthenticationException("Expired or invalid JWT token");
//        }
//    }
}
