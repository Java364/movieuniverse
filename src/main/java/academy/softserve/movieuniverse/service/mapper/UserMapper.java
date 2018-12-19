package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.MovieMarkController;
import academy.softserve.movieuniverse.controller.UserController;
import academy.softserve.movieuniverse.controller.UserReviewMarkController;
import academy.softserve.movieuniverse.dto.user.UserCreateInfo;
import academy.softserve.movieuniverse.dto.user.UserDTO;
import academy.softserve.movieuniverse.dto.user.UserFullInfo;
import academy.softserve.movieuniverse.dto.user.UserShortInfo;
import academy.softserve.movieuniverse.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class UserMapper {

    private final MovieMarkMapper movieMarkMapper;
    private final UserReviewDtoMapper userReviewDtoMapper;

    @Autowired
    public UserMapper(MovieMarkMapper movieMarkMapper, UserReviewDtoMapper userReviewDtoMapper) {
        this.movieMarkMapper = movieMarkMapper;
        this.userReviewDtoMapper = userReviewDtoMapper;
    }

    private UserDTO copyEntityPropertiesToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setBirthday(user.getBirthday());
        userDTO.add(linkTo(methodOn(UserController.class).showById(userDTO.getUserId())).withSelfRel());
        userDTO.add(linkTo(methodOn(UserController.class).showAllNonRemoved()).withRel("users"));
        userDTO.add(linkTo(methodOn(UserReviewMarkController.class).showOneUserReviewMark(userDTO.getUserId())).withRel("reviews"));
        userDTO.add(linkTo(methodOn(MovieMarkController.class).showAllByUserId(userDTO.getUserId())).withRel("movieMarks"));
        System.out.println(user);
        if (user.getIsRemoved()) {
            userDTO.add(linkTo(methodOn(UserController.class).restoreById(userDTO.getUserId())).withRel("restore"));
            userDTO.add(linkTo(methodOn(UserController.class).deleteById(userDTO.getUserId())).withRel("delete"));
        } else {
            userDTO.add(linkTo(methodOn(UserController.class).removeById(userDTO.getUserId())).withRel("remove"));
        }
        return userDTO;
    }

    public User mapUserShortInfoWithPasswordToEntity(UserCreateInfo user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setBirthday(user.getBirthday());
        return newUser;
    }

    public UserFullInfo mapUserEntityToUserDTOWithFullInfo(User user) {
        UserDTO userDTO = copyEntityPropertiesToDTO(user);
        userDTO.setPassword(user.getPassword());
        userDTO.setRemoved(user.getIsRemoved());
        userDTO.setEntryCreationDate(user.getEntryCreationDate());
        userDTO.setEntryLastUpdate(user.getEntryLastUpdate());
        return userDTO;
    }

    public UserCreateInfo mapUserEntityToUserDTOWithShortInfoAndPassword(User user) {
        UserDTO userDTO = copyEntityPropertiesToDTO(user);
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public UserShortInfo mapUserEntityToUserDTOWithShortInfo(User user) {
        UserDTO userDTO = copyEntityPropertiesToDTO(user);
        return userDTO;
    }

    public List<UserFullInfo> mapUserEntityListToUserWithFullInfoList(List<User> users) {
        return users.stream().map(this::mapUserEntityToUserDTOWithFullInfo).collect(Collectors.toList());
    }

    public List<UserShortInfo> mapUserEntityListToUserWithShortInfoList(List<User> users) {
        return users.stream().map(this::mapUserEntityToUserDTOWithShortInfo).collect(Collectors.toList());
    }


}
