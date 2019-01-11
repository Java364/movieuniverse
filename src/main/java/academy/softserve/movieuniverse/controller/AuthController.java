package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.user.UserCreateInfo;
import academy.softserve.movieuniverse.dto.user.UserFullInfo;
import academy.softserve.movieuniverse.dto.user.UserLoginInfo;
import academy.softserve.movieuniverse.mapper.CommentMapper;
import academy.softserve.movieuniverse.mapper.MovieMarkMapper;
import academy.softserve.movieuniverse.mapper.UserMapper;
import academy.softserve.movieuniverse.security.TokenModel;
import academy.softserve.movieuniverse.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth", produces = "application/hal+json")

public class AuthController {
    private final AuthService authService;
    private final UserMapper userMapper;

    @Autowired
    public AuthController(AuthService authService, UserMapper userMapper) {
        this.authService = authService;
        this.userMapper = userMapper;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserFullInfo> registration(@RequestBody UserCreateInfo userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.mapUserEntityToUserDTOWithFullInfo(
                authService.createUser(userMapper.mapUserShortInfoWithPasswordToEntity(userDTO))));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginInfo loginDTO) {

        TokenModel token = null;
        String e = loginDTO.getEmail();
        String p = loginDTO.getPassword();
        System.out.println("email -  "+ e +"  password -" +p);
        if (authService.checkCredentials(loginDTO)) {

            token = authService.signIn(loginDTO);
            System.out.println(token);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
