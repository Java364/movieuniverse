package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.dto.UserProfileDTO;
import academy.softserve.movieuniverse.dto.UserRegistrationDTO;
import academy.softserve.movieuniverse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserProfileDTO getUser(Long id){
        userRepository.getOne(id);
        return null;
    }

    private UserProfileDTO createUser(UserRegistrationDTO userDTO){
        return null;
    }

    private void deleteUser(Long id){
    }

    private List<UserProfileDTO> getAll(){
        return null;
    }
}
