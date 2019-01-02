package academy.softserve.movieuniverse.security.services;

import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(ExceptionType.SELECT.getMessage() + "email");
        }
        return withUsername(email).password(user.getPassword())
                .authorities(String.valueOf(user.getRole())).accountExpired(false).accountLocked(false).credentialsExpired(false)
                .disabled(false).build();
}}
