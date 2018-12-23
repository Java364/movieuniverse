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


import academy.softserve.movieuniverse.dto.LikeDTO;

import academy.softserve.movieuniverse.entity.Like;

import academy.softserve.movieuniverse.service.LikeService;
import academy.softserve.movieuniverse.service.mapper.LikeMapper;
@CrossOrigin
@RestController
@RequestMapping("/like")
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	@Autowired
	private LikeMapper likeMapper;
	
	@GetMapping("/all")
    public ResponseEntity<List<LikeDTO>> listAllLikes() {
        List<Like> likes = likeService.findAll();
        if (likes.isEmpty()) {
            return new ResponseEntity<List<LikeDTO>>(HttpStatus.NO_CONTENT);
        }
        List<LikeDTO> likeDTOs = likeMapper.mapListToDto(likes);
        return new ResponseEntity<List<LikeDTO>>(likeDTOs, HttpStatus.OK);
    }
	@PostMapping
	ResponseEntity<LikeDTO> create(@RequestBody LikeDTO likeDTO) {
		Like like = likeMapper.mapToEntityForSave(likeDTO);
		like = likeService.save(like);
		likeDTO = likeMapper.mapToDto(like);
		return new ResponseEntity<LikeDTO>(likeDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<LikeDTO> update(@PathVariable("id") Long id, @RequestBody LikeDTO likeDTO) {
		Like like = likeMapper.mapToEntityForUpdate(likeDTO, id);
		like = likeService.update(like);
		likeDTO = likeMapper.mapToDto(like);
		return new ResponseEntity<LikeDTO>(likeDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
    public ResponseEntity<LikeDTO> show(@PathVariable Long id) {
		Like like = likeService.findById(id);
        return new ResponseEntity<>(likeMapper.mapToDto(like), HttpStatus.OK);
    }
	
	@DeleteMapping("/like/{id}")
	public ResponseEntity<String> completelyDelete(@PathVariable Long id) {
		likeService.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}