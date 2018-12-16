package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.UserDTO;
import academy.softserve.movieuniverse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/user")
    public ResponseEntity createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/api/users")
    public ResponseEntity getAllUsers(){
        return new ResponseEntity(HttpStatus.OK);
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
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return new ResponseEntity(HttpStatus.OK);
    }



}
