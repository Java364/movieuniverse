package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.moviemark.MovieMarkDTO;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.service.MovieMarkService;
import academy.softserve.movieuniverse.service.MovieService;
import academy.softserve.movieuniverse.service.UserService;
import academy.softserve.movieuniverse.service.mapper.MovieMarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @PostMapping
    public ResponseEntity<MovieMarkDTO> create(@RequestBody MovieMarkDTO movieMarkDTO, @PathVariable Long movieId) {
        User user = userService.findById(1L);
        Movie movie = movieService.findMovieById(movieId);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieMarkMapper
                .mapToDto(movieMarkService.create(movieMarkMapper.mapToEntityForSave(movieMarkDTO, user, movie))));
    }

    @GetMapping
    public ResponseEntity<List<MovieMarkDTO>> showAll() {
        return ResponseEntity.status(HttpStatus.OK).body(movieMarkMapper.mapToDTOList(movieMarkService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieMarkDTO> showById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(movieMarkMapper.mapToDto(movieMarkService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieMarkDTO> update(@RequestBody MovieMarkDTO movieMarkDto, @PathVariable Long id) {
        MovieMark movieMark = movieMarkMapper.mapToEntityForUpdate(movieMarkDto, id);
        movieMark = movieMarkService.update(movieMark);
        return ResponseEntity.status(HttpStatus.OK).body(movieMarkMapper.mapToDto(movieMark));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieMarkService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<MovieMarkDTO>> showAllByUserId(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(movieMarkMapper.mapToDTOList(movieMarkService.findAllByUser(user)));
    }
}
