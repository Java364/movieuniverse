package academy.softserve.movieuniverse.mapper;

import academy.softserve.movieuniverse.controller.UserController;
import academy.softserve.movieuniverse.dto.user.UserCreateInfo;
import academy.softserve.movieuniverse.dto.user.UserDTO;
import academy.softserve.movieuniverse.dto.user.UserFullInfo;
import academy.softserve.movieuniverse.dto.user.UserShortInfo;

import academy.softserve.movieuniverse.entity.Role;
import academy.softserve.movieuniverse.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class UserMapper {

    @Autowired
    public UserMapper() {

    }

    private UserDTO copyEntityPropertiesToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setRole(user.getRole());
        userDTO.setSelf(linkTo(methodOn(UserController.class).showById(user.getId())).withSelfRel().getHref());
        userDTO.setUsers(linkTo(methodOn(UserController.class).showAllNonRemoved()).withRel("users").getHref());
        userDTO.setComments(
                linkTo(methodOn(UserController.class).showUserComments(user.getId())).withRel("comments").getHref());
        userDTO.setComments(linkTo(methodOn(UserController.class).showUserMovieMarks(user.getId()))
                .withRel("movieMarks").getHref());
        return userDTO;
    }

    public User mapUserShortInfoWithPasswordToEntity(UserCreateInfo user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setBirthday(user.getBirthday());
        newUser.setRole(Role.USER);
        return newUser;
    }

    public UserFullInfo mapUserEntityToUserDTOWithFullInfo(User user) {
        UserDTO userDTO = copyEntityPropertiesToDTO(user);
        userDTO.setPassword(user.getPassword());
        userDTO.setRemoved(user.getIsRemoved());
        userDTO.setRole(user.getRole());
        userDTO.setEntryCreationDate(user.getEntryCreationDate().getTime());
        userDTO.setEntryLastUpdate(user.getEntryLastUpdate().getTime());
        return userDTO;
    }

    public UserCreateInfo mapUserEntityToUserDTOCreateInfo(User user) {
        UserDTO userDTO = copyEntityPropertiesToDTO(user);
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public UserShortInfo mapUserEntityToUserDTOWithShortInfo(User user) {
        return copyEntityPropertiesToDTO(user);
    }

    public List<UserFullInfo> mapUserEntityListToUserWithFullInfoList(List<User> users) {
        return users.stream().map(this::mapUserEntityToUserDTOWithFullInfo).collect(Collectors.toList());
    }

    public List<UserShortInfo> mapUserEntityListToUserWithShortInfoList(List<User> users) {
        return users.stream().map(this::mapUserEntityToUserDTOWithShortInfo).collect(Collectors.toList());
    }

}
