package academy.softserve.movieuniverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import academy.softserve.movieuniverse.dto.MovieMarkDTO;
import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.service.MovieMarkService;
import academy.softserve.movieuniverse.service.mapper.MovieMarkMapper;

@RestController
public class MovieMarkController {
	
	@Autowired
	private MovieMarkService movieMarkService;
	
	private MovieMarkMapper movieMarkMapper =  new MovieMarkMapper();
	
	@PostMapping("/api/movieMark")
	ResponseEntity<MovieMarkDTO> createMovieMark(@RequestBody MovieMarkDTO movieMarkDTO){
		MovieMark movieMark = movieMarkMapper.mapToEntity(movieMarkDTO);
		movieMark = movieMarkService.createMovieMark(movieMark);
		movieMarkDTO = movieMarkMapper.mapToDto(movieMark);
		
		return new ResponseEntity<MovieMarkDTO>(movieMarkDTO, HttpStatus.CREATED);
	}
	
//	@GetMapping("/api/movieMarks")
//	List<MovieMarkDTO> findAllMovieMarks() {
//		
//		return movieMarkMapper.(movieMarkService.findAllMovieMarks());;
	}
	
	@GetMapping("/api/movieMark/{id}")
	ResponseEntity<MovieMark> findMovieMarkById(@PathVariable Long id) {
		MovieMark movieMark = movieMarkService.getMovieMark(id);
		return new ResponseEntity<MovieMark>(movieMark, HttpStatus.OK);
	}
}
