package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.user.UserCreateInfo;
import academy.softserve.movieuniverse.dto.user.UserFullInfo;
import academy.softserve.movieuniverse.dto.user.UserShortInfo;
import academy.softserve.movieuniverse.service.UserService;
import academy.softserve.movieuniverse.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/users", produces = "application/hal+json")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/include-removed")
    public ResponseEntity<Resources<UserShortInfo>> showAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new Resources<>(userMapper.mapUserEntityListToUserWithShortInfoList(
                        userService.findAll()),
                        linkTo(methodOn(UserController.class).showAll()).withSelfRel()));
    }

    @GetMapping
    public ResponseEntity<Resources<UserShortInfo>> showAllNonRemoved() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new Resources<>(userMapper.mapUserEntityListToUserWithShortInfoList(
                        userService.findAllByIsRemovedFalse()),
                        linkTo(methodOn(UserController.class).showAllNonRemoved()).withSelfRel()));
    }

    @PostMapping
    public ResponseEntity<UserFullInfo> create(@RequestBody UserCreateInfo userDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userMapper.mapUserEntityToUserDTOWithFullInfo(
                        userService.createUser(
                                userMapper.mapUserShortInfoWithPasswordToEntity(userDTO)
                        )
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserFullInfo> showById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userMapper.mapUserEntityToUserDTOWithFullInfo(
                        userService.findById(id))
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserFullInfo> update(@PathVariable Long id, @RequestBody UserCreateInfo userDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userMapper.mapUserEntityToUserDTOWithFullInfo(
                        userService.update(
                                userMapper.mapUserShortInfoWithPasswordToEntity(userDTO), id)
                ));
    }

    @PatchMapping("/{id}/remove")
    public ResponseEntity removeById(@PathVariable Long id) {
        userService.removeById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{id}/restore")
    public ResponseEntity restoreById(@PathVariable Long id) {
        userService.restoreById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
