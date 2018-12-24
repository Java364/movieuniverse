package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.CommentController;
import academy.softserve.movieuniverse.controller.MovieMarkController;
import academy.softserve.movieuniverse.controller.UserController;
import academy.softserve.movieuniverse.dto.user.UserCreateInfo;
import academy.softserve.movieuniverse.dto.user.UserDTO;
import academy.softserve.movieuniverse.dto.user.UserFullInfo;
import academy.softserve.movieuniverse.dto.user.UserShortInfo;
import academy.softserve.movieuniverse.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
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
        userDTO.add(linkTo(methodOn(UserController.class).showById(user.getId())).withSelfRel());
        userDTO.add(linkTo(methodOn(UserController.class).showAllNonRemoved()).withRel("users"));
        userDTO.add(linkTo(methodOn(CommentController.class).findAllByUserId(user.getId())).withRel("comments"));
        userDTO.add(linkTo(methodOn(MovieMarkController.class).showAllByUserId(user.getId())).withRel("movieMarks"));
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

    public UserCreateInfo mapUserEntityToUserDTOCreateInfo(User user) {
        UserDTO userDTO = copyEntityPropertiesToDTO(user);
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public UserShortInfo mapUserEntityToUserDTOWithShortInfo(User user) {
        return copyEntityPropertiesToDTO(user);
    }

    public Resources<UserFullInfo> mapUserEntityListToUserWithFullInfoList(List<User> users) {
        return new Resources<>(users.stream().map(this::mapUserEntityToUserDTOWithFullInfo).collect(Collectors.toList()),
                linkTo(methodOn(UserController.class).showAllNonRemoved()).withSelfRel());
    }

    public Resources<UserShortInfo> mapUserEntityListToUserWithShortInfoList(List<User> users) {
        return new Resources<>(users.stream().map(this::mapUserEntityToUserDTOWithShortInfo).collect(Collectors.toList()),
                linkTo(methodOn(UserController.class).showAllNonRemoved()).withSelfRel());
    }


}
