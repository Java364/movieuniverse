package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.moviemark.MovieMarkDTO;
import academy.softserve.movieuniverse.dto.user.UserCreateInfo;
import academy.softserve.movieuniverse.dto.user.UserFullInfo;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.service.MovieMarkService;
import academy.softserve.movieuniverse.service.MovieService;
import academy.softserve.movieuniverse.service.UserService;
import academy.softserve.movieuniverse.service.mapper.MovieMarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping("/moviemark")
@RequestMapping("/movie/{movieId}/moviemark")
public class MovieMarkController {

	@Autowired
	private MovieMarkService movieMarkService;
	@Autowired
	private UserService userService;
	@Autowired
	private MovieMarkMapper movieMarkMapper;
	@Autowired
	private MovieService movieService;

//	@PostMapping
//	public ResponseEntity<MovieMarkDTO> create(@RequestBody MovieMarkDTO movieMarkDTO) {
//		MovieMark movieMark = movieMarkMapper.mapToEntityForSave(movieMarkDTO);
//		movieMark = movieMarkService.create(movieMark);
//		movieMarkDTO = movieMarkMapper.mapToDto(movieMark);
//		return new ResponseEntity<MovieMarkDTO>(movieMarkDTO, HttpStatus.CREATED);
//	}

	@PostMapping
	public ResponseEntity<MovieMarkDTO> create(@RequestBody MovieMarkDTO movieMarkDTO, @PathVariable Long movieId) {
		User user = userService.findById(1L);
		Movie movie = movieService.findMovieById(movieId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(
				movieMarkMapper.mapToDto(
						movieMarkService.create(
								movieMarkMapper.mapToEntityForSave(movieMarkDTO,user, movie)
								)
						));
	}

//    @GetMapping
//    List<MovieMarkDTO> showAll() {
//        return movieMarkMapper.mapListToDto(movieMarkService.findAll());
//    }

	@GetMapping
	public ResponseEntity<Resources<MovieMarkDTO>> showAll() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Resources<>(movieMarkMapper.mapListToDto(movieMarkService.findAll()),
						linkTo(methodOn(MovieMarkController.class).showAll()).withSelfRel()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovieMarkDTO> showById(@PathVariable Long id) {
		MovieMark movieMark = movieMarkService.findById(id);
		MovieMarkDTO movieMarkDTO = movieMarkMapper.mapToDto(movieMark);
		return new ResponseEntity<MovieMarkDTO>(movieMarkDTO, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MovieMarkDTO> update(@RequestBody MovieMarkDTO movieMarkDto, @PathVariable Long id) {
		MovieMark movieMark = movieMarkMapper.mapToEntityForUpdate(movieMarkDto, id);
		movieMark = movieMarkService.update(movieMark);
		movieMarkDto = movieMarkMapper.mapToDto(movieMark);
		return new ResponseEntity<MovieMarkDTO>(movieMarkDto, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		movieMarkService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/users/{id}")
	public List<MovieMarkDTO> showAllByUserId(@PathVariable Long id) {
		User user = userService.findById(id);
		return movieMarkMapper.mapListToDto(movieMarkService.findAllByUser(user));
	}
}
