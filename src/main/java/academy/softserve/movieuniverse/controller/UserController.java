package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.moviemark.MovieMarkDTO;
import academy.softserve.movieuniverse.dto.user.UserCreateInfo;
import academy.softserve.movieuniverse.dto.user.UserFullInfo;
import academy.softserve.movieuniverse.dto.user.UserShortInfo;
import academy.softserve.movieuniverse.dto.userreview.CommentDTO;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.mapper.CommentMapper;
import academy.softserve.movieuniverse.mapper.MovieMarkMapper;
import academy.softserve.movieuniverse.mapper.UserMapper;
import academy.softserve.movieuniverse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/users", produces = "application/hal+json")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final CommentMapper commentMapper;
    private final MovieMarkMapper movieMarkMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper, CommentMapper commentMapper,
            MovieMarkMapper movieMarkMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.commentMapper = commentMapper;
        this.movieMarkMapper = movieMarkMapper;
    }

    @GetMapping("/include-removed")
    public ResponseEntity<List<UserShortInfo>> showAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userMapper.mapUserEntityListToUserWithShortInfoList(userService.findAll()));
    }

    @GetMapping
    public ResponseEntity<List<UserShortInfo>> showAllNonRemoved() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userMapper.mapUserEntityListToUserWithShortInfoList(userService.findAllNonRemoved()));
    }

    @PostMapping
    public ResponseEntity<UserFullInfo> create(@RequestBody UserCreateInfo userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.mapUserEntityToUserDTOWithFullInfo(
                userService.createUser(userMapper.mapUserShortInfoWithPasswordToEntity(userDTO))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserFullInfo> showById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userMapper.mapUserEntityToUserDTOWithFullInfo(userService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserFullInfo> update(@PathVariable Long id, @RequestBody UserCreateInfo userDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(userMapper.mapUserEntityToUserDTOWithFullInfo(
                userService.update(userMapper.mapUserShortInfoWithPasswordToEntity(userDTO), id)));
    }

    @DeleteMapping("/{id}/remove")
    public ResponseEntity<?> removeById(@PathVariable Long id) {
        userService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/restore")
    public ResponseEntity<?> restoreById(@PathVariable Long id) {
        userService.restoreById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<CommentDTO>> showUserComments(@PathVariable Long id) {
        User user = userService.findById(id);
        List<CommentDTO> commentDTOS = commentMapper.mapToDTOList(user.getComments(), commentMapper::mapToDTO);
        return ResponseEntity.status(HttpStatus.OK).body(commentDTOS);
    }

    @GetMapping("/{id}/movie-marks")
    public ResponseEntity<List<MovieMarkDTO>> showUserMovieMarks(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(movieMarkMapper.mapToDTOList(user.getMovieMarks()));
    }
    /*@PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void registerUser(@Valid @RequestBody RegistrationDTO registrationDTO) {
        userService.registerUser(registrationDTO);
    }*/

}
