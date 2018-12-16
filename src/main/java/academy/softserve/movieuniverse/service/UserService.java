package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User getUser(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }
    @Transactional
    public User createUser(User user){
        return userRepository.saveAndFlush(user);
    }
    @Transactional
    public void completelyDeleteUser(Long id){
        userRepository.deleteById(id);
    }

    @Transactional
    public void markUserAsDelete(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        userOptional.ifPresent(user -> user.setIsRemoved(true));
        userRepository.saveAndFlush(userOptional.get());
    }

    @Transactional
    public User updateUser(User user, Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User userDB = userOptional.get();
            user.setId(userDB.getId());
            BeanUtils.copyProperties(user, userDB);
            return userRepository.saveAndFlush(userDB);
        }
        return null;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
    
    public User findUserById(Long id){
    	
    	return userRepository.getOne(id);
    }
}
