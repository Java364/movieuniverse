package academy.softserve.movieuniverse.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import academy.softserve.movieuniverse.dto.UserReviewMarkDTO;

import academy.softserve.movieuniverse.entity.UserReviewMark;

import academy.softserve.movieuniverse.service.UserReviewMarkService;
import academy.softserve.movieuniverse.service.mapper.UserReviewMarkMapper;
@CrossOrigin
@RestController
@RequestMapping("/userReviewMark")
public class UserReviewMarkController {
	
	@Autowired
	private UserReviewMarkService userReviewMarkService;
	@Autowired
	private UserReviewMarkMapper userReviewMarkMapper;
	
	@GetMapping("/all")
    public ResponseEntity<List<UserReviewMarkDTO>> listAllUserReviewMarks() {
        List<UserReviewMark> userReviewMarks = userReviewMarkService.findAll();
        if (userReviewMarks.isEmpty()) {
            return new ResponseEntity<List<UserReviewMarkDTO>>(HttpStatus.NO_CONTENT);
        }
        List<UserReviewMarkDTO> userReviewMarkDTOs = userReviewMarkMapper.mapListToDto(userReviewMarks);
        return new ResponseEntity<List<UserReviewMarkDTO>>(userReviewMarkDTOs, HttpStatus.OK);
    }
	@PostMapping
	ResponseEntity<UserReviewMarkDTO> createUserReviewMark(@RequestBody UserReviewMarkDTO userReviewMarkDTO) {
		UserReviewMark userReviewMark = userReviewMarkMapper.mapToEntityForSave(userReviewMarkDTO);
		userReviewMark = userReviewMarkService.save(userReviewMark);
		userReviewMarkDTO = userReviewMarkMapper.mapToDto(userReviewMark);
		return new ResponseEntity<UserReviewMarkDTO>(userReviewMarkDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<UserReviewMarkDTO> updateUserReviewMark(@PathVariable("id") Long id, @RequestBody UserReviewMarkDTO userReviewMarkDTO) {
		UserReviewMark userReviewMark = userReviewMarkMapper.mapToEntityForUpdate(userReviewMarkDTO, id);
		userReviewMark = userReviewMarkService.update(userReviewMark);
		userReviewMarkDTO = userReviewMarkMapper.mapToDto(userReviewMark);
		return new ResponseEntity<UserReviewMarkDTO>(userReviewMarkDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
    public ResponseEntity<UserReviewMarkDTO> showOneUserReviewMark(@PathVariable Long id) {
		UserReviewMark userReviewMark = userReviewMarkService.findById(id);
        return new ResponseEntity<>(userReviewMarkMapper.mapToDto(userReviewMark), HttpStatus.OK);
    }
	
	@DeleteMapping("/userReviewMark/{id}")
	public ResponseEntity<String> fullyDeleteUserReviewMark(@PathVariable Long id) {
		userReviewMarkService.deleteUserReviewMark(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}