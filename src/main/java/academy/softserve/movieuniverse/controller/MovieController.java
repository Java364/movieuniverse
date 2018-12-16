package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.MovieDTO;
import academy.softserve.movieuniverse.dto.interfaces.MovieCreateDTO;
import academy.softserve.movieuniverse.dto.interfaces.MovieInfoDTO;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.service.MovieService;
import academy.softserve.movieuniverse.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService service;

    @Autowired
    private MovieMapper movieMapper;

    @GetMapping("")
    List<MovieDTO> showAllMovies() {
        List<Movie> movies = service.showAllMovies();
        return movieMapper.mapListToDTO(movies);
    }

    @GetMapping("/{id}")
    ResponseEntity<MovieInfoDTO> showOneMovie(@PathVariable Long id) {
        Movie movie = service.findMovieById(id);
        MovieInfoDTO movieInfoDTO = movieMapper.mapToDto(movie);
        return new ResponseEntity<MovieInfoDTO>(movieInfoDTO, HttpStatus.OK);
    }

    @PostMapping("")
    ResponseEntity<MovieCreateDTO> createMovie(@RequestBody MovieCreateDTO movieCreateDTO) {
        Movie movie = movieMapper.mapToEntity((MovieDTO) movieCreateDTO);
        movie = service.saveMovie(movie);
        movieCreateDTO = movieMapper.mapToDto(movie);
        return new ResponseEntity<MovieCreateDTO>(movieCreateDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<MovieCreateDTO> updateMovie(@RequestBody MovieCreateDTO movieCreateDTO, @PathVariable Long id) {
        Movie movie = movieMapper.mapToEntity((MovieDTO) movieCreateDTO);
        movie = service.updateMovie(movie, id);
        movieCreateDTO = movieMapper.mapToDto(movie);
        return new ResponseEntity<MovieCreateDTO>(movieCreateDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        service.deleteMovie(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}