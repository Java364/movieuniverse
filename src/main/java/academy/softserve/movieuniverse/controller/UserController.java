package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.UserProfileDTO;
import academy.softserve.movieuniverse.dto.UserRegistrationDTO;
import academy.softserve.movieuniverse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/user")
    public ResponseEntity<UserProfileDTO> createUser(@RequestBody UserRegistrationDTO userDTO) {
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<UserProfileDTO> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UserProfileDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity completelyDeleteUser(@PathVariable Long id) {
        userService.completelyDeleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/api/user/remove/{id}")
    public ResponseEntity markUserAsDelete(@PathVariable Long id) {
        userService.markUserAsDelete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<UserProfileDTO> updateUser(@PathVariable Long id, @RequestBody UserRegistrationDTO userRegistrationDTO) {
        return new ResponseEntity<>(userService.updateUser(userRegistrationDTO, id), HttpStatus.OK);
    }



}
