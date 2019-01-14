package academy.softserve.movieuniverse.security;

import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Let people login with email
        final User user = userRepository.findByEmail(email);
        if (email == null)
            throw new UsernameNotFoundException("User not found with email : " + email);
        return org.springframework.security.core.userdetails.User.withUsername(email).password(user.getPassword())
                .authorities(user.getRole()).accountExpired(false).accountLocked(false).credentialsExpired(false)
                .disabled(false).build();

    }

    /*
     * @Transactional public UserDetails loadUserById(Long id) { User user = userRepository.findById(id).orElseThrow(()
     * -> new RuntimeException("User not found with" + id)); return UserPrincipal.create(user); }
     */

}