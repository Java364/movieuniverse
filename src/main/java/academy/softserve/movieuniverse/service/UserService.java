package academy.softserve.movieuniverse.service;


import academy.softserve.movieuniverse.dto.user.UserCreateInfo;
import academy.softserve.movieuniverse.dto.user.UserLoginInfo;
import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.entity.Role;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.exception.NotFoundException;
import academy.softserve.movieuniverse.repository.UserRepository;
import academy.softserve.movieuniverse.security.JwtTokenProvider;
import academy.softserve.movieuniverse.security.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
@Autowired
private PasswordEncoder passwordEncoder;
@Autowired
private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ExceptionType.SELECT.getMessage() + "user with " + id.toString() + " ID"));
    }

    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())){
            System.out.println("eeeeeeee");
        }else{
        User user1 = new User();
        user1.setEmail(user.getEmail());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setRole(Role.USER);
        user1.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.saveAndFlush(user1);
    }
        return user;
    }
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public boolean checkCredentials(UserLoginInfo loginDTO) {
        if (userRepository.existsByEmail(loginDTO.getEmail()) && passwordEncoder.matches(loginDTO.getPassword(),
                userRepository.findByEmail(loginDTO.getEmail()).getPassword())) {
            return true;
        } else {
            return false;
        }
    }
    public TokenModel signIn(UserLoginInfo loginDTO) {
        String email = loginDTO.getEmail();
        //   String password = loginDTO.getPassword();
        TokenModel tokenModel = new TokenModel();
        // authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        tokenModel.setAccessToken(jwtTokenProvider.generateAccessToken(userRepository.findByEmail(email).getId(),email,
                userRepository.findByEmail(email).getRole() ));
        System.out.println(userRepository.findByEmail(email).getRole());
        tokenModel.setRefreshToken(jwtTokenProvider.generateRefreshToken(loginDTO.getEmail()));
        return tokenModel;
    }

    public void deleteById(Long id) {
        if (!userRepository.findById(id).isPresent())
            throw new NotFoundException(ExceptionType.DELETE.getMessage() + "user with ID - " + id.toString());
        userRepository.deleteById(id);
    }

    public void removeById(Long id) {
        userRepository.findById(id).map(user -> {
            user.setIsRemoved(true);
            return userRepository.saveAndFlush(user);
        }).orElseThrow(
                () -> new NotFoundException(ExceptionType.DELETE.getMessage() + "user with " + id.toString() + " ID"));
    }

    public void restoreById(Long id) {
        userRepository.findById(id).map(user -> {
            user.setIsRemoved(false);
            return userRepository.saveAndFlush(user);
        }).orElseThrow(
                () -> new NotFoundException(ExceptionType.SELECT.getMessage() + "user with " + id.toString() + " ID"));
    }

    public User update(User user, Long id) {
        return userRepository.findById(id).map(userDB -> {
            userDB.setEmail(user.getEmail());
            userDB.setPassword(user.getPassword());
            userDB.setFirstName(user.getFirstName());
            userDB.setLastName(user.getLastName());
            userDB.setBirthday(user.getBirthday());
            return userRepository.saveAndFlush(userDB);
        }).orElseThrow(() -> new NotFoundException(ExceptionType.UPDATE.getMessage() + " user"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findAllNonRemoved() {
        return userRepository.findAllByIsRemoved(false);
    }

    public User findByMovieMarks(MovieMark movieMark) {
        return userRepository.findByMovieMarks(movieMark);

    }

}
