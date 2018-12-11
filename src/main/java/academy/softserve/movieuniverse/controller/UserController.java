package academy.softserve.movieuniverse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import academy.softserve.movieuniverse.dto.UserDTO;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	ResponseEntity<User> createUser(@RequestBody User user) {
		user = userService.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/api/user/{id}")
	ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
		User user = userService.getUser(id);
		UserDTO userDto = new UserDTO();
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		return new ResponseEntity<UserDTO>(userDto, HttpStatus.OK);
	}
	
	@PostMapping("/api/user2")
	ResponseEntity<UserDTO> testCreateUser(@RequestBody UserDTO user) {
		return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
	}
}
