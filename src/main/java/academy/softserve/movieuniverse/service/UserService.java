package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.exception.NotFoundException;
import academy.softserve.movieuniverse.repository.UserRepository;
import academy.softserve.movieuniverse.security.JwtTokenProvider;
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
