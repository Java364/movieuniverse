package academy.softserve.movieuniverse.security;

import academy.softserve.movieuniverse.entity.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwtSecret}")
    private String jwtSecret;
    @Value("${jwtExpiration}")
    private int jwtExpiration;
    @Value("${jwtbearer}")
    private String bearer;

    public String generateToken(Long id, String email, Role role) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("id", id);
        claims.put("role", role);
        Date date = new Date();
        Date validity = new Date(date.getTime() + jwtExpiration);

        return Jwts.builder().setClaims(claims).setIssuedAt(date).setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            throw new RuntimeException("Invalid JWT signature");
        }

    }
}
