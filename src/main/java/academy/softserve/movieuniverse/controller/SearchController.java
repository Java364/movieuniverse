package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.movie.MovieSearchShortInfo;
import academy.softserve.movieuniverse.dto.star.StarSearchShortInfo;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.mapper.MovieMapper;
import academy.softserve.movieuniverse.mapper.StarMapper;
import academy.softserve.movieuniverse.service.MovieService;
import academy.softserve.movieuniverse.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/search")
public class SearchController {

    private final StarService starService;
    private final StarMapper starMapper;
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @Autowired
    public SearchController(StarService starService, StarMapper starMapper, MovieService movieService,
            MovieMapper movieMapper) {
        this.starService = starService;
        this.starMapper = starMapper;
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping("/star")
    public ResponseEntity<List<StarSearchShortInfo>> showStarsByName(@RequestParam String name) {
        List<Star> stars = starService.findAllByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(starMapper.mapListEntityToStarSearchShortInfoList(stars));
    }

    @GetMapping("/movie")
    public ResponseEntity<List<MovieSearchShortInfo>> showMoviesByName(@RequestParam String name) {
        List<Movie> movies = movieService.findAllByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(movieMapper.mapListToMovieSearchShortInfoList(movies));
    }

}
