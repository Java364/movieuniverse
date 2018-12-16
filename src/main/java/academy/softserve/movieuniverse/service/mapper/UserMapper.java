package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.user.UserDTO;
import academy.softserve.movieuniverse.dto.user.UserFullInfo;
import academy.softserve.movieuniverse.dto.user.UserShortInfo;
import academy.softserve.movieuniverse.dto.user.UserShortInfoWithPassword;
import academy.softserve.movieuniverse.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    private final MovieMarkMapper movieMarkMapper;
    private final UserReviewDtoMapper userReviewDtoMapper;

    @Autowired
    public UserMapper(MovieMarkMapper movieMarkMapper, UserReviewDtoMapper userReviewDtoMapper) {
        this.movieMarkMapper = movieMarkMapper;
        this.userReviewDtoMapper = userReviewDtoMapper;
    }

    public User mapUserShortInfoWithPasswordToEntity(UserShortInfoWithPassword user){
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setBirthday(user.getBirthday());
        return newUser;
    }

    public UserFullInfo mapUserEntityToUserDTOWithFullInfo(User user){
        UserFullInfo userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setEntryCreationDate(user.getEntryCreationDate());
        userDTO.setEntryLastUpdate(user.getEntryLastUpdate());
        userDTO.setRemoved(user.getIsRemoved());
        //TODO userDTO.setUserReviewDTOList();
        userDTO.setUserReviewDTOList(new ArrayList<>());
        userDTO.setMovieMarkDTOList(movieMarkMapper.mapListToDto(user.getMovieMarks()));
        return userDTO;
    }

    public UserShortInfoWithPassword mapUserEntityToUserDTOWithShortInfoAndPassword(User user){
        UserShortInfoWithPassword userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setBirthday(user.getBirthday());
        return userDTO;
    }

    public UserShortInfo mapUserEntityToUserDTOWithShortInfo(User user){
        UserShortInfo userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setBirthday(user.getBirthday());
        return userDTO;
    }

    public List<UserFullInfo> mapUserEntityListToUserWithFullInfoList(List<User> users){
        return users.stream().map(this::mapUserEntityToUserDTOWithFullInfo).collect(Collectors.toList());
    }

    public List<UserShortInfo> mapUserEntityListToUserWithShortInfoList(List<User> users){
        return users.stream().map(this::mapUserEntityToUserDTOWithShortInfo).collect(Collectors.toList());
    }

    public List<UserShortInfoWithPassword> mapUserEntityListToUserWithShortInfoWithPasswordList(List<User> users){
        return users.stream().map(this::mapUserEntityToUserDTOWithShortInfoAndPassword).collect(Collectors.toList());
    }


}
