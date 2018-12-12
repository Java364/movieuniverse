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

import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.service.MovieMarkService;

@RestController
public class MovieMarkController {
	
	@Autowired
	private MovieMarkService movieMarkService;
	
	@PostMapping("/api/movieMark")
	ResponseEntity<MovieMark> createMovieMark(@RequestBody MovieMark movieMark) {
		movieMark = movieMarkService.createMovieMark(movieMark);
		
		return new ResponseEntity<MovieMark>(movieMark, HttpStatus.OK);
	}
	
	@GetMapping("/api/movieMarks")
	List<MovieMark> findAllMovieMarks() {
		List<MovieMark> movieMarkList = movieMarkService.findAllMovieMarks();
		return movieMarkList;
	}
	
	@GetMapping("/api/movieMark/{id}")
	ResponseEntity<MovieMark> findMovieMarkById(@PathVariable Long id) {
		MovieMark movieMark = movieMarkService.getMovieMark(id);
		return new ResponseEntity<MovieMark>(movieMark, HttpStatus.OK);
	}
}
