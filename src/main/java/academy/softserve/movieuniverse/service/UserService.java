package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.exception.UserException;
import academy.softserve.movieuniverse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> UserException.createSelectException(String.format("No such user with id = %d", id), new Exception()));
    }


    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public void deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> UserException.createDeleteException(String.format("No such user with id = %d", id), new Exception()));
        if (user.getIsRemoved()) {
            userRepository.deleteById(id);
        } else {
            throw UserException.createDeleteException("Wrong operation for such status", new Exception());
        }
    }

    public void removeById(Long id) {
        userRepository.findById(id)
                .map(user -> {
                    user.setIsRemoved(true);
                    return userRepository.saveAndFlush(user);
                })
                .orElseThrow(() -> UserException.createDeleteException(String.format("No such user with id = %d", id), new Exception()));
    }

    public void restoreById(Long id) {
        userRepository.findById(id)
                .map(user -> {
                    user.setIsRemoved(false);
                    return userRepository.saveAndFlush(user);
                })
                .orElseThrow(() -> UserException.createDeleteException(String.format("No such user with id = %d", id), new Exception()));
    }

    public User update(User user, Long id) {
        return userRepository.findById(id)
                .map(userDB -> {
                    userDB.setEmail(user.getEmail());
                    userDB.setPassword(user.getPassword());
                    userDB.setFirstName(user.getFirstName());
                    userDB.setLastName(user.getLastName());
                    userDB.setBirthday(user.getBirthday());
                    return userRepository.saveAndFlush(userDB);
                }).orElseThrow(() -> UserException.createDeleteException(String.format("No such user with id = %d", id), new Exception()));
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
