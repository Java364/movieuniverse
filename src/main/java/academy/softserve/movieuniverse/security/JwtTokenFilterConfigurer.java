package academy.softserve.movieuniverse.security;


import academy.softserve.movieuniverse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenFilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
   @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    public JwtTokenFilterConfigurer(JwtTokenProvider jwtTokenProvider, UserRepository userRepository) {
        this.jwtTokenProvider = jwtTokenProvider;

        this.userRepository = userRepository;
    }
    /*@Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterAfter(new JwtAuthFilter(jwtTokenProvider, userRepository), BasicAuthenticationFilter.class);
    }*/
}
