package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.entity.StarActivityInMovies;
import academy.softserve.movieuniverse.service.StarActivityInMoviesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarActivityInMoviesController {

    private StarActivityInMoviesService starActivityInMoviesService;

    public StarActivityInMoviesController(StarActivityInMoviesService starActivityInMoviesService) {
        this.starActivityInMoviesService = starActivityInMoviesService;
    }

    @GetMapping("/star-activity-in-movies")
    public List<StarActivityInMovies> getAllStarActivityInMovies() {
        return starActivityInMoviesService.findAllStarActivityInMovies();
    }

    @GetMapping("/star-activity-in-movies/{id}")
    public StarActivityInMovies getStarActivityInMoviesById(@PathVariable Long id) {
        return starActivityInMoviesService.getStarActivityInMovies(id);
    }
}
