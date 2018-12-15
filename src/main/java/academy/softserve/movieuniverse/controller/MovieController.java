package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.MovieDTO;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.service.MovieService;
import academy.softserve.movieuniverse.service.StarService;
import academy.softserve.movieuniverse.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService service;
    private MovieMapper listMapper = new MovieMapper();

    @GetMapping("/list")
    List<MovieDTO> showAllMovies() {
        List<Movie> movies = service.showAllMovie();
        return listMapper.mapListToDTO(movies);
    }

    @GetMapping("/{id}")
    Optional<Movie> showOneMovie(@PathVariable("id") Long id) {
        return service.findMovieById(id);
    }

    @PostMapping("/create")
    ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        movie = service.saveMovie(movie);
        return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
    }

}