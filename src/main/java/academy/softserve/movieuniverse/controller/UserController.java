package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.controller.hateoas.UserResourceAssembler;
import academy.softserve.movieuniverse.dto.user.UserDTO;
import academy.softserve.movieuniverse.dto.user.UserShortInfo;
import academy.softserve.movieuniverse.dto.user.UserShortInfoWithPassword;
import academy.softserve.movieuniverse.service.UserService;
import academy.softserve.movieuniverse.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RestController("/api/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserResourceAssembler userResourceAssembler;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper, UserResourceAssembler userResourceAssembler) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.userResourceAssembler = userResourceAssembler;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<UserDTO> users = userMapper.mapUserEntityListToUserWithShortInfoList(
                userService.getAll()).stream().map(userShortInfo ->(UserDTO) userShortInfo).collect(Collectors.toList());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userResourceAssembler.listToResource(users));
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserShortInfoWithPassword userDTO) throws URISyntaxException {
        Resource<UserDTO> resource = userResourceAssembler.toResource((UserDTO)
                userMapper.mapUserEntityToUserDTOWithShortInfo(
                        userService.createUser(
                                userMapper.mapUserShortInfoWithPasswordToEntity(userDTO)
                        )
                )
        );
        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity markUserAsDelete(@PathVariable Long id) {
        userService.markUserAsDelete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity completelyDeleteUser(@PathVariable Long id) {
        userService.completelyDeleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
