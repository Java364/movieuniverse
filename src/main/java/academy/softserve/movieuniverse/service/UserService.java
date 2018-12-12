package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.dto.UserProfileDTO;
import academy.softserve.movieuniverse.dto.UserRegistrationDTO;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.repository.UserRepository;
import academy.softserve.movieuniverse.service.mapper.UserProfileMapper;
import academy.softserve.movieuniverse.service.mapper.UserRegistrationMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public UserProfileDTO getUser(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        return userProfileMapper.mapToDto(userOptional.get());
    }
    @Transactional
    public UserProfileDTO createUser(UserRegistrationDTO userDTO){
        return userProfileMapper.mapToDto(userRepository.saveAndFlush(userRegistrationMapper.mapToEntity(userDTO)));
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
    public UserProfileDTO updateUser(UserRegistrationDTO userDTO, Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User user = userRegistrationMapper.mapToEntity(userDTO);
            User userDB = userOptional.get();
            user.setId(userDB.getId());
            BeanUtils.copyProperties(user, userDB);
            return userProfileMapper.mapToDto(userRepository.saveAndFlush(userDB));
        }
        return userProfileMapper.mapToDto(userRegistrationMapper.mapToEntity(userDTO));
    }

    public List<UserProfileDTO> getAll(){
        return userProfileMapper.mapListToDTO(userRepository.findAll());
    }
    
    public User findUserById(Long id){
    	
    	return userRepository.getOne(id);
    }
}
