package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.dto.user.UserCreateInfo;
import academy.softserve.movieuniverse.dto.user.UserLoginInfo;
import academy.softserve.movieuniverse.entity.Role;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.repository.UserRepository;
import academy.softserve.movieuniverse.security.JwtTokenProvider;
import academy.softserve.movieuniverse.security.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
        } else {
            User registration = new User();
            registration.setEmail(user.getEmail());
            registration.setFirstName(user.getFirstName());
            registration.setLastName(user.getLastName());
            registration.setRole(Role.USER);
            registration.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(registration);
        }
        return user;
    }

    public boolean validatorRegistration(UserCreateInfo userDTO) {
        if ((userDTO.getEmail().isEmpty()) || (!userDTO.getEmail().contains("@"))
                || ((userDTO.getFirstName().length() > 15) || userDTO.getFirstName().contains(" "))
                || ((userDTO.getLastName().length() > 15) || userDTO.getLastName().contains(" "))
                || (userDTO.getPassword().isEmpty())
                || ((userDTO.getPassword().length() > 20) || userDTO.getPassword().contains(" "))
                || (userDTO.getPassword().length() < 6))
            return true;
        else
            return false;
    }

    public boolean checkCredentials(UserLoginInfo loginDTO) {
        if (userRepository.existsByEmail(loginDTO.getEmail()) && passwordEncoder.matches(loginDTO.getPassword(),
                userRepository.findByEmail(loginDTO.getEmail()).getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public TokenModel signIn(UserLoginInfo loginDTO) {
        String email = loginDTO.getEmail();

        // String password = loginDTO.getPassword();
        TokenModel tokenModel = new TokenModel();
        // authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        tokenModel.setAccessToken(jwtTokenProvider.generateAccessToken(userRepository.findByEmail(email).getId(), email,
                userRepository.findByEmail(email).getRole()));
        System.out.println(userRepository.findByEmail(email).getRole());
        /* tokenModel.setRefreshToken(jwtTokenProvider.generateRefreshToken(loginDTO.getEmail())); */

        return tokenModel;
    }

}
