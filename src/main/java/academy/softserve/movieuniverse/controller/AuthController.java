package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.user.UserCreateInfo;
import academy.softserve.movieuniverse.dto.user.UserFullInfo;
import academy.softserve.movieuniverse.dto.user.UserLoginInfo;
import academy.softserve.movieuniverse.email.EmailBuilder;
import academy.softserve.movieuniverse.email.EmailService;
import academy.softserve.movieuniverse.mapper.UserMapper;
import academy.softserve.movieuniverse.security.TokenModel;
import academy.softserve.movieuniverse.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth", produces = "application/hal+json")

public class AuthController {

    @Autowired
    private EmailBuilder emailBuilder;
    @Autowired
    private EmailService emailService;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/signup")
    public ResponseEntity<UserFullInfo> registration(@RequestBody UserCreateInfo userDTO) {
        if (authService.validatorRegistration(userDTO)) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        } else {
            System.out.println("2323232");
            ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(userMapper.mapUserEntityToUserDTOWithFullInfo(
                    authService.createUser(userMapper.mapUserShortInfoWithPasswordToEntity(userDTO))));
            emailService.welcomeEmail(userDTO.getEmail(), userDTO.getFirstName());
            return responseEntity;
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginInfo loginDTO) {
        TokenModel token = null;
        String e = loginDTO.getEmail();
        String p = loginDTO.getPassword();
        System.out.println("email -  " + e + "  password -" + p);
        if (authService.checkCredentials(loginDTO)) {
            token = authService.signIn(loginDTO);
            System.out.println(token);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/forgotPass/{email}")
    public ResponseEntity sendNewPassword(@PathVariable String email) {
        emailBuilder.newPassword(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
