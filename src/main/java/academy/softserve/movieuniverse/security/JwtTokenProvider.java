package academy.softserve.movieuniverse.security;

import academy.softserve.movieuniverse.entity.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.SignatureException;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwtSecret}")
    private String jwtSecret;

    @Value("${jwtExpiration}")
    private int jwtExpiration;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    private Authentication auth;

    public String generateAccessToken(Long id, String email, Role role) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("id", id);
        claims.put("role", role.getAuthority());
        Date expiryDate = new Date();
        Date validity = new Date(expiryDate.getTime() + jwtExpiration);
        return Jwts.builder().setClaims(claims).setIssuedAt(expiryDate).setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
    }

    public String getJwtAccessFromRequest(HttpServletRequest req) {

        String bearerToken = req.getHeader("Authorization");
        /*System.out.println(bearerToken);*/
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(getEmail(token));
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, "",
                userDetails.getAuthorities());
        return authentication;
    }

    public String getEmail(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public String generateRefreshToken(String email) {
        Claims claims = Jwts.claims().setSubject(email);
        Date expiryDate = new Date();
        Date validity = new Date(expiryDate.getTime() + jwtExpiration);
        return Jwts.builder().setClaims(claims).setIssuedAt(expiryDate).setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
    }

    /*
     * public String refreshToken(String token) { final Date createdDate = clock.now(); final Date expirationDate =
     * calculateExpirationDate(createdDate);
     * 
     * final Claims claims = getAllClaimsFromToken(token); claims.setIssuedAt(createdDate);
     * claims.setExpiration(expirationDate);
     * 
     * return Jwts.builder() .setClaims(claims) .signWith(SignatureAlgorithm.HS512, secret) .compact(); }
     */

    public String getJwtRefreshFromRequest(HttpServletRequest req) {
        return req.getHeader("Refresh-token");
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
        return true;

    }
}
