package academy.softserve.movieuniverse.security;

import academy.softserve.movieuniverse.entity.Role;
import academy.softserve.movieuniverse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try { String accessToken = jwtTokenProvider.getJwtAccessFromRequest(request);
              String refreshToken = jwtTokenProvider.getJwtRefreshFromRequest(request);

            if (accessToken != null && jwtTokenProvider.validateToken(accessToken)) {
                Authentication authentication = jwtTokenProvider.getAuthentication(accessToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else if (refreshToken != null && jwtTokenProvider.validateToken(refreshToken)
                    && !jwtTokenProvider.validateToken(accessToken)) {
                // checkExpiration(accessToken)
                String email = jwtTokenProvider.getEmail(refreshToken);
                /// removeAlreadyFiltredAttributes
                Role role = userRepository.findByEmail(email).getRole();
                Long id = userRepository.findByEmail(email).getId();
                response.setHeader("Access-token", jwtTokenProvider.generateAccessToken(id, email, role));
                response.setHeader("Refresh-token", jwtTokenProvider.generateRefreshToken(email));
            }
        } catch (RuntimeException e) {

        }
        filterChain.doFilter(request, response);
    }}