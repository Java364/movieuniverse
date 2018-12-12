package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.dto.UserProfileDTO;
import academy.softserve.movieuniverse.dto.UserRegistrationDTO;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.repository.UserRepository;
import academy.softserve.movieuniverse.service.mapper.UserProfileMapper;
import academy.softserve.movieuniverse.service.mapper.UserRegistrationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserProfileMapper userProfileMapper;
    private final UserRegistrationMapper userRegistrationMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserProfileMapper userProfileMapper, UserRegistrationMapper userRegistrationMapper) {
        this.userRepository = userRepository;
        this.userProfileMapper = userProfileMapper;
        this.userRegistrationMapper = userRegistrationMapper;
    }

    private UserProfileDTO getUser(Long id){
        return userProfileMapper.mapToDto(userRepository.getOne(id));
    }

    private UserProfileDTO createUser(UserRegistrationDTO userDTO){
        return userProfileMapper.mapToDto(userRepository.saveAndFlush(userRegistrationMapper.mapToEntity(userDTO)));
    }

    private void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    private List<UserProfileDTO> getAll(){
        return userProfileMapper.mapListToDTO(userRepository.findAll());
    }
}
