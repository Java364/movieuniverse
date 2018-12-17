package academy.softserve.movieuniverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import academy.softserve.movieuniverse.dto.UserReviewMarkDTO;
import academy.softserve.movieuniverse.entity.UserReviewMark;
import academy.softserve.movieuniverse.service.UserReviewMarkService;
import academy.softserve.movieuniverse.service.mapper.UserReviewMarkMapper;

@RestController
public class UserReviewMarkController {
	
	@Autowired
	private UserReviewMarkService userReviewMarkService;
	@Autowired
	private UserReviewMarkMapper userReviewMarkMapper;
	
	@PostMapping("/userReviewMark")
	ResponseEntity<UserReviewMarkDTO> createUserReviewMark(@RequestBody UserReviewMarkDTO userReviewMarkDTO) {
		UserReviewMark userReviewMark = userReviewMarkMapper. mapToEntity(userReviewMarkDTO);
		userReviewMark = userReviewMarkService.saveUserReviewMark(userReviewMark);
		userReviewMarkDTO = userReviewMarkMapper.mapToDto(userReviewMark);
		return new ResponseEntity<UserReviewMarkDTO>(userReviewMarkDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/userReviewMark/{id}")
	ResponseEntity<UserReviewMarkDTO> updateUserReviewMark(@PathVariable("id") Long id, @RequestBody UserReviewMarkDTO userReviewMarkDTO) {
		UserReviewMark userReviewMark = userReviewMarkMapper.mapToEntityForUpdate(userReviewMarkDTO, id);
		userReviewMark = userReviewMarkService.updateUserReviewMark(userReviewMark);
		userReviewMarkDTO = userReviewMarkMapper.mapToDto(userReviewMark);
		return new ResponseEntity<UserReviewMarkDTO>(userReviewMarkDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/userReviewMark/{id}")
    public ResponseEntity<UserReviewMarkDTO> showOneUserReviewMark(@PathVariable Long id) {
		UserReviewMark userReviewMark = userReviewMarkService.findUserReviewMarkById(id);
        return new ResponseEntity<>(userReviewMarkMapper.mapToDto(userReviewMark), HttpStatus.OK);
    }
	
	@DeleteMapping("/userReviewMark/{id}")
	public ResponseEntity<String> fullyDeleteUserReviewMark(@PathVariable Long id) {
		userReviewMarkService.deleteUserReviewMark(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}